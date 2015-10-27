package controllers

import models.TestApp
import play.api._
import play.api.mvc._

class Apps extends Controller {

  def index = Action {
    val appList = List(
      TestApp("repose"),
      TestApp("not_repose")
    )
    Ok(views.html.index(appList))
  }

  def applicationDetails(currentApp: String) = Action {

    //TODO: this should hit a database or something
    val currentApp = TestApp("repose")

    val name = "Repose - todo"
    val description = "description - todo"
    val title = "Repose - todo"


    Ok(views.html.app_index(title, name, description, currentApp))
  }

  def applicationSubApps(currentApp: String) = TODO

}
