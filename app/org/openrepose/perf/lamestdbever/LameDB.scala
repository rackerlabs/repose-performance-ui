package org.openrepose.perf.lamestdbever

import models.{SubTestApp, TestApp}

/**
 * The lamest, but fastest, database ever.
 */
object LameDB {

  val appList = List(
    TestApp("repose", "Repose", "Repose is an open-source RESTful HTTP reverse proxy that is highly scalable and extensible. It provides solutions to API processing tasks such as rate limiting, client authentication, versioning, and logging."),
    TestApp("not_repose", "Not Repose", "this is the lame entry for something that is not repose")
  )

  val subApps = List(
    SubTestApp("repose", "atom_hopper", "Atom Hopper Setup", "Setup of Repose for atom hopper application."),
    SubTestApp("repose", "identity", "identity", "repose configuration for cloud identity"),
    SubTestApp("repose", "translation", "translation", "repose configuration for translation"),
    SubTestApp("repose", "dbaas", "Cloud Databases", "Repose setup with DBaaS configurations"),
    SubTestApp("repose", "cloud_queues", "Cloud Queues", "Repose setup with Cloud Queues configurations"),
    SubTestApp("repose", "connection_pool", "Connection Pool", "Tests for connection pooling"),
    SubTestApp("repose", "aeauth", "AE Auth Tokens", "Repose test for large identity tokens"),
    SubTestApp("repose", "rl_eventservice", "Rate Limit - Event Service", "Repose test for rate limiting with event service"),
    SubTestApp("repose", "tracing", "Tracing", "Repose test for tracing"),
    SubTestApp("repose", "apicoverage", "Api Coverage", "Repose test for api coverage")
  )

  def listApps = appList

  def getAppDetails(appId: String): Option[TestApp] = {
    appList.find(_.id == appId)
  }

  def getSubAppDetails(subAppId: String): Option[SubTestApp] = {
    subApps.find(_.id == subAppId)
  }

  def listSubApps(parentApp: TestApp): List[SubTestApp] = {
    subApps.filter(sub => sub.parentId == parentApp.id)
  }
}
