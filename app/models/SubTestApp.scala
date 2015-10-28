package models

case class SubTestApp(parentId: String, id: String, name: String, description: String)

case class SubTestAppResults(subTestApp: SubTestApp, result: String) //TODO: this should probably not be a string, but instead a strong type (passed, failed)