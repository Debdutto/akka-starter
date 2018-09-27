package org.akka_starter.api.sample

import akka.actor.ActorSystem
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.{Directives, Route}
import org.akka_starter.models.response.PostResponse
import org.akka_starter.models.response.GetResponse
import org.akka_starter.models.user.User

import scala.concurrent.ExecutionContext

/**
  * Class to implement the /combo Route
  *
  * @param executionContext Execution Context
  * @@soundtrack 309 - Live - Russian Circles
  */
class Combo(implicit executionContext: ExecutionContext, actorSystem: ActorSystem) extends Directives {


  // Included to allow conversion from JSON to Rule (Case class)
  import org.akka_starter.models.user.UserJsonProtocol._

  val postRoute: Route = {
    post
    entity(as[User]) { user =>
        val response = PostResponse(message = StatusCodes.OK.defaultMessage, data = user).toHttpResponse
        complete(response)
    }
  }

  val getRoute: Route = {
    get
    parameters('userId.?) { userId =>
      val response = GetResponse(message = StatusCodes.OK.defaultMessage, data = s"You again? Bug off $userId").toHttpResponse
      complete(response)
    }
  }

  val route: Route = concat(
    postRoute,
    getRoute
  )
}