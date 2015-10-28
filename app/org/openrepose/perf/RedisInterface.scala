package org.openrepose.perf

import models.{ResponseData, RequestData, SubTestApp}
import org.openrepose.perf.lamestdbever.LameRedis
import play.api.Logger

object RedisInterface {

  import play.api.libs.functional.syntax._
  import play.api.libs.json.Reads._
  import play.api.libs.json._

  implicit val requestDataReads: Reads[RequestData] = (
    (JsPath \ "method").read[String] and
    (JsPath \ "uri").read[String] and
    (JsPath \ "headers").read[List[Map[String,String]]] and
    (JsPath \ "body").read[String]
    )(RequestData.apply _)

  def parseRequestsFromRedis(subApp: SubTestApp): List[RequestData] = {

    ///Ignoring the sub app bits which would actually talk to redis, because I'm lazy and this is a fake DB
    val json = Json.parse(LameRedis.lameRequestJson)
    json.validate[List[RequestData]] match {
      case s: JsSuccess[List[RequestData]] => s.get
      case e: JsError =>
        Logger.error(s"COULDN'T PARSE THE JSON! ${JsError.toJson(e)}")
        List.empty[RequestData]
    }
  }

  def parseResponsesFromRedis(subApp: SubTestApp): List[ResponseData] = {
    val json = Json.parse(LameRedis.lameResponseJson)

    //HOLY CRAP THIS WAS FRUSTRATING
    //TODO: I'm not even wholly certain this keeps an order :|
    val wat:List[String] = (json \\ "response_code").map { item =>
      item.as[String]
    }.toList

    wat.map(item => ResponseData(item.toInt))
  }
}
