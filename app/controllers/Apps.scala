package controllers

import models.{SubTestAppResults, TestApp}
import org.openrepose.perf.lamestdbever.LameDB
import play.api._
import play.api.mvc._

class Apps extends Controller {

  //https://github.com/rackerlabs/repose-performance-ui/blob/master/README.md#get-
  def index = Action {
    Ok(views.html.index(LameDB.listApps))
  }

  //https://github.com/rackerlabs/repose-performance-ui/blob/master/README.md#get-app
  def applicationDetails(currentApp: String) = Action {

    //TODO: this should hit a database or something
    LameDB.getAppDetails(currentApp).map { tehApp =>
      val title = s"Application details for ${tehApp.name}"
      Ok(views.html.app_index(title, tehApp.name, tehApp.description, tehApp))
    } getOrElse {
      NotFound
    }

  }

  //https://github.com/rackerlabs/repose-performance-ui/blob/master/README.md#get-appapplicationssubapp
  def applicationSubApps(appId: String) = Action {
    LameDB.getAppDetails(appId) map { app =>
      val subApps = app.subApps
      Ok(views.html.sub_apps_list(app, subApps))
    } getOrElse {
      NotFound(s"CANT FIND APP BY ID $appId")
    }
  }

  //https://github.com/rackerlabs/repose-performance-ui/blob/master/README.md#get-appapplicationsresults
  def allResults(appId: String) = Action {
    LameDB.getAppDetails(appId) map { app =>
      val subApps = app.subApps
      //TODO: for each test run on all the subapps, get the details and determine if it failed or not.
      //That's a pile of some sort of data from REDIS, not sure what it looks like
      // REDIS KEY: s"$appId:${subApp.id}:results:status" value would either be passed or failed
      //It mutates the subApps, which is kind of annoying, will have to figure out a way to deal with that somehow
      // Perahps a different class to contain it


      val subAppsWithResults = subApps.map { subApp =>
        SubTestAppResults(subApp, "passed")
      }


      Ok(views.html.app_results(app, subAppsWithResults))
    } getOrElse {
      NotFound(s"CANT FIND APP BY ID $appId")
    }
  }

}
