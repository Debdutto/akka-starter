package org.akka_starter.models.response

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.{HttpResponse, _}
import spray.json._

/**
  * Get Response Case Class
  * @param message Response Message
  * @param data Response Data
  * @@soundtrack Fake Plastic Trees - Radiohead
  */
case class GetResponse
(
  message: String,
  data: String
) {
  def toHttpResponse: HttpResponse = {
    implicit val ruleResponseFormat: RootJsonFormat[GetResponse] = GetResponseJsonProtocol.getResponseFormat
    HttpResponse(StatusCodes.OK, entity = HttpEntity(ContentTypes.`application/json`, this.toJson.compactPrint))
  }
}

object GetResponseJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val getResponseFormat: RootJsonFormat[GetResponse] = jsonFormat2(GetResponse)
}