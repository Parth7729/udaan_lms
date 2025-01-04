lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "udaan_lms",
    organization := "com.example",
    version := "1.0-SNAPSHOT",
    crossScalaVersions := Seq("2.13.15", "3.3.3"),
    scalaVersion := crossScalaVersions.value.head,
    libraryDependencies ++= Seq(
      jdbc,
      evolutions,
      ws,
      "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test,
      "com.softwaremill.macwire" %% "macros" % "2.5.9" % "provided",

      "org.postgresql" % "postgresql" % "42.7.3",

      "org.scalikejdbc" %% "scalikejdbc" % "3.5.0",
      "org.scalikejdbc" %% "scalikejdbc-config" % "3.5.0",
      "org.scalikejdbc" %% "scalikejdbc-joda-time" % "3.5.0",
      "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.8.0-scalikejdbc-3.5",
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-Werror"
    )
  )