package org.openrepose.perf.lamestdbever

import play.api.libs.json.{JsNull, Json, JsString, JsValue}

object LameRedis {
  val lameRequestJson: String = Json.prettyPrint(Json.arr(
    Json.obj(
      "method" -> "GET",
      "uri" -> "http://www.example.com/",
      "headers" -> Json.arr(
        Json.obj("x-some-header" -> "LE VALUE"),
        Json.obj("x-header-too" -> "OTHER VALUE")
      ),
      "body" -> "THIS IS THE BODY. IT HAS TEXT, and SOME THINGS THAT RE NOT HTML SAFE !@%#^%&$#&%(*&^()*)><><><\":\":}{}{}"
    ),
    Json.obj(
      "method" -> "GET",
      "uri" -> "http://www.example.com/",
      "headers" -> Json.arr(
        Json.obj("x-some-header" -> "LE VALUE"),
        Json.obj("x-header-too" -> "OTHER VALUE")
      ),
      "body" -> "THIS IS THE BODY. IT HAS TEXT, and SOME THINGS THAT RE NOT HTML SAFE !@%#^%&$#&%(*&^()*)><><><\":\":}{}{}"
    ),
    Json.obj(
      "method" -> "GET",
      "uri" -> "http://www.example.com/",
      "headers" -> Json.arr(
        Json.obj("x-some-header" -> "LE VALUE"),
        Json.obj("x-header-too" -> "OTHER VALUE")
      ),
      "body" -> "THIS IS THE BODY. IT HAS TEXT, and SOME THINGS THAT RE NOT HTML SAFE !@%#^%&$#&%(*&^()*)><><><\":\":}{}{}"
    ),
    Json.obj(
      "method" -> "GET",
      "uri" -> "http://www.example.com/",
      "headers" -> Json.arr(
        Json.obj("x-some-header" -> "LE VALUE"),
        Json.obj("x-header-too" -> "OTHER VALUE")
      ),
      "body" -> "THIS IS THE BODY. IT HAS TEXT, and SOME THINGS THAT RE NOT HTML SAFE !@%#^%&$#&%(*&^()*)><><><\":\":}{}{}"
    ),
    Json.obj(
      "method" -> "GET",
      "uri" -> "http://www.example.com/",
      "headers" -> Json.arr(
        Json.obj("x-some-header" -> "LE VALUE"),
        Json.obj("x-header-too" -> "OTHER VALUE")
      ),
      "body" -> "THIS IS THE BODY. IT HAS TEXT, and SOME THINGS THAT RE NOT HTML SAFE !@%#^%&$#&%(*&^()*)><><><\":\":}{}{}"
    ),
    Json.obj(
      "method" -> "GET",
      "uri" -> "http://www.example.com/",
      "headers" -> Json.arr(
        Json.obj("x-some-header" -> "LE VALUE"),
        Json.obj("x-header-too" -> "OTHER VALUE")
      ),
      "body" -> "THIS IS THE BODY. IT HAS TEXT, and SOME THINGS THAT RE NOT HTML SAFE !@%#^%&$#&%(*&^()*)><><><\":\":}{}{}"
    ),
    Json.obj(
      "method" -> "GET",
      "uri" -> "http://www.example.com/",
      "headers" -> Json.arr(
        Json.obj("x-some-header" -> "LE VALUE"),
        Json.obj("x-header-too" -> "OTHER VALUE")
      ),
      "body" -> "THIS IS THE BODY. IT HAS TEXT, and SOME THINGS THAT RE NOT HTML SAFE !@%#^%&$#&%(*&^()*)><><><\":\":}{}{}"
    )
  ))

  val lameResponseJson: String = Json.prettyPrint(Json.arr(
    Json.obj(
      "response_code" -> "200"
    ),
    Json.obj(
      "response_code" -> "200"
    ),
    Json.obj(
      "response_code" -> "200"
    ),
    Json.obj(
      "response_code" -> "200"
    ),
    Json.obj(
      "response_code" -> "200"
    ),
    Json.obj(
      "response_code" -> "200"
    ),
    Json.obj(
      "response_code" -> "200"
    )
  ))


  /**
   * Ultra lame fake test method for doing stuff with redis. LOLOL I ARE A REDIS MACHEEEEEEEEEEEN
   * @param key
   * @return
   */
  def get(key: String): String = {
    key match {
      case "repose:atom_hopper:tests:setup:request_response:request" => lameRequestJson
      case "repose:atom_hopper:tests:setup:request_response:response" => lameResponseJson
      case _ => ""
    }
  }

}
