package org.openrepose.perf.lamestdbever

import models.{SubTestApp, TestApp}

object LameDB {

  val appList = List(
    TestApp("repose", "Repose", "This is the repose lame database entry"),
    TestApp("not_repose", "Not Repose", "this is the lame entry for something that is not repose")
  )

  val subApps = List(
    SubTestApp("repose", "subapp")
  )

  def listApps = appList

  def getAppDetails(appId: String): Option[TestApp] = {
    appList.find(_.id == appId)
  }

  def listSubApps(parentApp: TestApp): List[SubTestApp] = {
    subApps.filter(sub => sub.parentId == parentApp.id)
  }


}
