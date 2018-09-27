package org.akka_starter.api.sample

import akka.actor.ActorSystem
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.{Directives, Route}
import org.akka_starter.models.response.PostResponse
import org.akka_starter.models.user.User

import scala.concurrent.ExecutionContext

/**
  * Class to implement the /post Route
  *
  * @param executionContext Execution Context
  * @@soundtrack Bombtrack - Remastered - Rage Against The Machine
  */
class Post(implicit executionContext: ExecutionContext, actorSystem: ActorSystem) extends Directives {


  // Included to allow conversion from JSON to Rule (Case class)
  import org.akka_starter.models.user.UserJsonProtocol._

  val route: Route = {
    post
    entity(as[User]) { user =>
        val response = PostResponse(message = StatusCodes.OK.defaultMessage, data = user).toHttpResponse
        complete(response)
    }
  }
}