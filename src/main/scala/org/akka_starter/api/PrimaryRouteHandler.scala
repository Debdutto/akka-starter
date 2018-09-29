package org.akka_starter.api

import akka.actor.ActorSystem
import akka.http.scaladsl.coding.Gzip
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._
import org.akka_starter.api.sample.Sample
import org.akka_starter.modules.exception.{PrimaryExceptionHandler, PrimaryRejectionHandler}

import scala.concurrent.ExecutionContext

/**
  * Class to implement the main HTTP Route
  *
  * @param executionContext Execution Context
  * @param actorSystem      Akka Actor System
  * @@soundtrack The Mask of Anubis - Kryptos
  */
class PrimaryRouteHandler(implicit executionContext: ExecutionContext, actorSystem: ActorSystem) {

  val handler: Route = {
    extractUri {
      uri => {
        handleRejections(PrimaryRejectionHandler.handler) {
          handleExceptions(PrimaryExceptionHandler.handler) {
            cors() {
              encodeResponseWith(Gzip) {
                pathPrefix("sample") {
                  new Sample().handler
                } ~
                  path("ping") {
                    complete("pong")
                  }
              }
            }
          }
        }
      }
    }
  }
}