package controllers

import models.TestApp
import org.openrepose.perf.lamestdbever.LameDB
import play.api._
import play.api.mvc._

class Apps extends Controller {

  def index = Action {
    Ok(views.html.index(LameDB.listApps))
  }

  def applicationDetails(currentApp: String) = Action {

    //TODO: this should hit a database or something
    LameDB.getAppDetails(currentApp).map { tehApp =>
      val title = s"Application details for ${tehApp.name}"
      Ok(views.html.app_index(title, tehApp.name, tehApp.description, tehApp))
    } getOrElse {
      NotFound
    }

  }

  def applicationSubApps(appId: String) = Action {
    LameDB.getAppDetails(appId) map { app =>
      val subApps = app.subApps
      Ok(views.html.sub_apps_list(app, subApps))
    } getOrElse {
      NotFound(s"CANT FIND APP BY ID $appId")
    }
  }

}
