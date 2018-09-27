package org.akka_starter.api.sample

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import scala.concurrent.ExecutionContext

/**
  * Class to implement the /sample Route
  *
  * @param executionContext Execution Context
  * @param actorSystem      Akka Actor System
  * @@soundtrack Bowling For Peace - Prasanna
  */
class Sample(implicit executionContext: ExecutionContext, actorSystem: ActorSystem) {

  val handler: Route = {

    path("get") {
      new Get().route
    } ~
      path("post") {
        new Post().route
      } ~
      path("combo") {
        new Combo().route
      } ~
      path("exception") {
        new ExceptionRoute().route
      } ~
      pathEndOrSingleSlash {
        complete("End")
      }
  }
}