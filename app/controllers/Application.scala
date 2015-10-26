package controllers

import models.TestApplication
import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    val appList = List(
      TestApplication("repose"),
      TestApplication("not_repose")
    )
    Ok(views.html.index(appList))
  }

  def applicationDetails(appId: String) = TODO

  def applicationSubApps(appId: String) = TODO

}
