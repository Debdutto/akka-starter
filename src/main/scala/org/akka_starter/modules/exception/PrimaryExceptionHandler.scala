package org.akka_starter.modules.exception

import akka.http.scaladsl.model.{StatusCode, StatusCodes}
import akka.http.scaladsl.server
import akka.http.scaladsl.server.Directives.{complete, extractUri}
import akka.http.scaladsl.server.ExceptionHandler
import org.akka_starter.models.response.ErrorResponse
import org.akka_starter.modules.logger.{LogType, Logger}

/**
  * Common Exception Handler, Override at route if necessary
  *
  * @@soundtrack ...And Then I Was Found - Code I
  */
object PrimaryExceptionHandler {

  val handler = ExceptionHandler {
    case error: Exception => {
      logAndSendErrorResponse(error, "Unknown exception occurred", StatusCodes.InternalServerError)
    }
  }

  def logAndSendErrorResponse(error: Exception = null, errorMessage: String, errorCode: StatusCode): server.Route = {
    extractUri { uri =>
      Logger.log("GLOBAL_EXCEPTION", errorMessage, LogType.ERROR, Option(error))

      val response = ErrorResponse(errorCode.intValue, errorMessage).toHttpResponse
      complete(response)
    }
  }
}
