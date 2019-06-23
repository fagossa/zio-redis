import sbt._

object Dependencies {
  // effects
  lazy val zio = "org.scalaz" %% "scalaz-zio" % "1.0-RC4"
  // "org.scalaz" %% "scalaz-zio-streams" % "1.0-RC4",

  // logs
  lazy val logs = "ch.qos.logback" % "logback-classic" % "1.2.3"
  lazy val redis = "net.debasishg" %% "redisclient" % "3.10"

  // test
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.8"
}
