package org.akka_starter.api.sample

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import org.akka_starter.models.response.GetResponse

import scala.concurrent.ExecutionContext

/**
  * Class to implement the /get route
  *
  * @param executionContext Execution Context
  * @@soundtrack Settle For Nothing - Remastered - Rage Against The Machine
  */
class Get(implicit executionContext: ExecutionContext) {
  val route: Route = {
    get
    parameters('userId.as[String]) { userId =>
      val response = GetResponse(message = StatusCodes.OK.defaultMessage, data = s"Got userId=$userId. What am I supposed to do with it? Huh?").toHttpResponse
      complete(response)
    }
  }
}