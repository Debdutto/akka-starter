package org.akka_starter.models.response

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.{HttpResponse, _}
import spray.json._

/**
  * Error Response case class
  * @param status Response Status
  * @param message Response Message
  * @@soundtrack Universal Mind - Liquid Tension Experiment
  */
case class ErrorResponse
(
  status: Int = 500,
  message: String = "Error Occurred"
) {

  def toHttpResponse: HttpResponse = {
    implicit val errorResponseFormat: RootJsonFormat[ErrorResponse] = ErrorResponseJsonProtocol.errorResponseFormat
    HttpResponse(status, entity = HttpEntity(ContentTypes.`application/json`, this.toJson.compactPrint))
  }
}

object ErrorResponseJsonProtocol extends DefaultJsonProtocol with SprayJsonSupport with NullOptions {
  implicit val errorResponseFormat: RootJsonFormat[ErrorResponse] = jsonFormat2(ErrorResponse)
}