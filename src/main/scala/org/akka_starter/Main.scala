package org.akka_starter

import akka.actor._
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import org.akka_starter.api.PrimaryRouteHandler
import org.akka_starter.modules.Config
import org.akka_starter.modules.logger.{LogType, Logger}

import scala.concurrent.ExecutionContext
import scala.language.postfixOps

object Main extends App {

  /**
    * Method to start the main application\
    *
    * @return Server Binding
    * @@soundtrack Killing In The Name - Rage Against The Machine
    */
  def start() = {

    println("Started")

    implicit val actorSystem = ActorSystem("akka-starter-kit")
    implicit val executor: ExecutionContext = actorSystem.dispatcher
    implicit val materializer: ActorMaterializer = ActorMaterializer()

    val primaryRouteHandler = new PrimaryRouteHandler()

    Logger.log("APP_START", "Server has Started", LogType.INFO)

    /**
      * Accessing a common config, because I can
      */
    Config.config("put.common.properties.that.are.shared.across.environments.here")

    Http().bindAndHandle(handler = primaryRouteHandler.handler, interface = Config.config("http.host"), port = Config.config("http.port").toInt)
  }

  start()
}