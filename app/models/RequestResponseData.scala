package models

import play.api.libs.json.JsValue


/**
 * Container to hold the parse JS values from redis
 * TODO: use angular in the future to render the JSON directly?
 *
 */
case class RequestResponseData(request: RequestData, response: ResponseData)

case class RequestData(method: String, uri: String, rawHeaders: List[Map[String, String]], body: String){
  val headers = rawHeaders.foldLeft(Map.empty[String, String]){ (acc, li) =>
    acc ++ li
  }
}

case class ResponseData(responseCode: Int)