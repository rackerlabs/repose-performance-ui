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
    //For the given sub App, ask redis for each of the test liststs?

    val testTypes = LameDB.listTestTypes()
    //For each of these test types, get the status of the test that was ran against this sub app
    // If the status is not set, make it "passed"

    //Calculate a count of all the tests that have ever been run of this type
    //TODO this would have to come from the redis
    val testTypeCounts:Map[TestType, Int] = Map.empty[TestType, Int]

    //Now collect all the statuses for each type
    //TODO: all this would also have to come from some redis :(

    /*
    To do this, we'll have to have some results json, or figure out all the possible things from the ruby code.
    Unfortunately, the ruby code merges many objects together and deals with them all as one giant hash :( This
    makes it super hard to figure out what's from what :(

    You pars the json test results from line 17 of model/results.rb, aswell as the data result.

    Then you grab the "test" field, which has something, and you merge that with something that came in as part of the test_list. I think
    the test list is another JSON structure from redis.

    Then, there is two different ways to compile the summary results from either Gatling or JMeter. Not yet sure how that gets set.

    This mutates the state of the same test_hash we were building earlier :( Ugh. I have literally no idea what's going on right now.
    I think the compile summary results methods are just a way to collect details out of the plain text results from gatling. Some
    regexps exist to try to pull that data out. That would be a standalone module on its own. Something to parse the gatling result
    data from the redis stored data.

    Actually now I'm not even sure where it's getting the data, it's making an HTTP call to "fs_ip" AH, it's a file storage.
    Wow. This needs to be completely replaced with an agent running on the systems under test, or using an SSH connection
    to orchestrate the tests so we can collect those file bits and post them to the server, process them once, rather than
    every time (I think they're processed every time)

     */

    Ok("NOT YET DONE")
  }

}
