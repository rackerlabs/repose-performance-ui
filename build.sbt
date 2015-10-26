name := """repose-performance-ui"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  //This adds handy webjar support to play
  "org.webjars" %% "webjars-play" % "2.4.0-1",
  //Adding the bootstrap webjar, so I don't have to stick em in there
  "org.webjars" % "bootstrap" % "3.2.0-2",
  "org.webjars" % "highcharts" % "3.0.7",
  //Add redis
  "net.debasishg" %% "redisclient" % "3.0",
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
