package controllers

import models.{TestType, RequestResponseData, TestConfig}
import org.openrepose.perf.RedisInterface
import org.openrepose.perf.lamestdbever.LameDB
import play.api._
import play.api.mvc._

class SubApps extends Controller {
  //https://github.com/rackerlabs/repose-performance-ui/blob/master/README.md#get-appapplicationssubapp
  def subAppDetails(appId: String, subAppId: String) = Action {
    LameDB.getAppDetails(appId).map { app =>
      LameDB.getSubAppDetails(subAppId).map { subApp =>

        val requests = RedisInterface.parseRequestsFromRedis(subApp)
        val responses = RedisInterface.parseResponsesFromRedis(subApp)
        val paired = requests zip responses

        val requestResponseList = paired.map { case (request, response) =>
          RequestResponseData(request, response)
        }

        Ok(views.html.sub_app_detail(app, subApp, requestResponseList, Map.empty[String, TestConfig]))
      } getOrElse {
        NotFound("COULDNT FIND SUBAPP DETAILS")
      }
    } getOrElse {
      NotFound("COULDNT FIND APP DETAILS")
    }
  }

  //https://github.com/rackerlabs/repose-performance-ui/blob/master/README.md#get-appresultsresultid
  def resultDetails(appId: String, resultId: String) = Action {
    //For the given sub App, ask redits for each of the test liststs?


    val testTypes = LameDB.listTestTypes()
    //For each of these test types, get the status of the test that was ran against this sub app
    // If the status is not set, make it "passed"

    //Calculate a count of all the tests that have ever been run of this type
    //TODO this would have to come from the redis
    val testTypeCounts:Map[TestType, Int] = Map.empty[TestType, Int]

    //Now collect all the statuses for each type
    //TODO: all this would also have to come from some redis :(

    Ok("NOT YET DONE")
  }

}
