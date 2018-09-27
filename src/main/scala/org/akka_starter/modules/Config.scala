package org.akka_starter.modules

import java.io.InputStream

object Config {

  /**
    * Set sys variable ENVIRONMENT or change here
    */
  lazy val config: Map[String, String] = load(getEnv())

  /**
    * @param environment
    * @return Map of config params from environment resource files
    * @@soundtrack Mládek - Live - Russian Circles
    */
  private def load(environment: String = "dev") = {

    var configurationMap = Map[String, String]()

    val propertyFileName = "/" + environment + "/application.properties"

    val commonPropertyFileName = "/common/application.properties"

    // load config file according to env, default is dev
    val stream: InputStream = getClass.getResourceAsStream(propertyFileName)
    val commonStream: InputStream = getClass.getResourceAsStream(commonPropertyFileName)
    //Merges Two Iterators
    val lines = scala.io.Source.fromInputStream(stream).getLines ++ scala.io.Source.fromInputStream(commonStream).getLines

    // remove the commented lines from config file
    val uncommentedLines = lines.map(_.trim).filter(!_.startsWith("#")).filter(_.contains("="))

    // Add all config items to a map
    uncommentedLines.foreach(line => {

      val Array(a, b) = line.split("=", 2)

      configurationMap += (a.trim -> b.trim)

    })
    configurationMap
  }

  def getEnv(): String ={
    try {
      sys.env("ENVIRONMENT")
    } catch {
      case _: Exception => "dev"
    }
  }
}