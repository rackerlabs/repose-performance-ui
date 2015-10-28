package org.openrepose.perf.lamestdbever

import models.{TestType, SubTestApp, TestApp}

/**
 * The lamest, but fastest, database ever.
 */
object LameDB {

  val appList = List(
    TestApp("test_app", "Test App", "There's data in the REDIS for this!"),
    TestApp("repose", "Repose", "Repose is an open-source RESTful HTTP reverse proxy that is highly scalable and extensible. It provides solutions to API processing tasks such as rate limiting, client authentication, versioning, and logging."),
    TestApp("not_repose", "Not Repose", "this is the lame entry for something that is not repose")
  )

  val subApps = List(
    SubTestApp("test_app", "test_sub_app", "SUB APP", "IT EXISTS"),
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

  def listTestTypes(): List[TestType] = {
    List(
      TestType("Load Test", "Test running for a sample duration at 120% of expected load for the application."),
      TestType("Duration Test", "Test running for a longer duration than average (optimally 12 to 48 hours at 75% expected load)"),
      TestType("Stress Test", "Test running with constant increasing load until application fails"),
      TestType("Adhoc Test", "Test with custom settings. A one-time only iteration")
    )
  }
}
