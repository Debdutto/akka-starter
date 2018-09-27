package org.akka_starter.modules.exception

import akka.http.scaladsl.model.{StatusCode, StatusCodes}
import akka.http.scaladsl.server.Directives.{complete, extractUri}
import akka.http.scaladsl.server.{Rejection, _}
import org.akka_starter.models.response.ErrorResponse
import org.akka_starter.modules.logger.{LogType, Logger}


/**
  * Common Rejection Handler, Override at route if necessary
  *
  * @@soundtrack Mirror Messiah - Black Pyramid
  */
object PrimaryRejectionHandler {

  val handler: RejectionHandler = RejectionHandler.newBuilder().handle {
    case error: Rejection => {
      logAndSendRejectionResponse(error, "Unknown Rejection", StatusCodes.BadRequest)
    }
  }.result()

  def logAndSendRejectionResponse(error: Rejection = null, errorMessage: String, errorCode: StatusCode): Route = {
    extractUri { uri =>
      Logger.log("GLOBAL_EXCEPTION", errorMessage, LogType.ERROR, Option(new Exception(error.toString)))
      val response = ErrorResponse(errorCode.intValue, errorMessage).toHttpResponse
      complete(response)
    }
  }
}
