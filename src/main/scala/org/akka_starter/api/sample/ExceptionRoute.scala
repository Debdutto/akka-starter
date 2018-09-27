package org.akka_starter.api.sample

import akka.actor.ActorSystem
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.{Directives, Route}

import scala.concurrent.ExecutionContext

/**
  * Class to implement the /exception Route
  *
  * @param executionContext Execution Context
  * @@soundtrack Quantum Entanglement - Rivu
  */
class ExceptionRoute(implicit executionContext: ExecutionContext, actorSystem: ActorSystem) extends Directives {
  val route: Route = {
    get
    parameters('userId.?) { userId =>
      // Let's play some catch
      throw new Exception("I'm not a ball, why all this throwing and shit man?")
      complete(StatusCodes.OK)
    }
  }
}