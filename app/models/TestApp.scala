package models

import org.openrepose.perf.lamestdbever.LameDB

case class TestApp(id: String, name: String, description: String) {
  lazy val subApps = {
    LameDB.listSubApps(this)
  }
}

