package org.akka_starter.models.response

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.{HttpResponse, _}
import org.akka_starter.models.user.User
import spray.json._

/**
  * Post Response Case Class
  * @param message Response Message
  * @param data Response Data
  * @@soundtrack Street Spirit (Fade Out) - Radiohead
  */
case class PostResponse
(
  message: String,
  data: User
) {
  def toHttpResponse: HttpResponse = {
    implicit val postResponseResponseFormat: RootJsonFormat[PostResponse] = PostResponseJsonProtocol.postResponseResponseFormat
    HttpResponse(StatusCodes.OK, entity = HttpEntity(ContentTypes.`application/json`, this.toJson.compactPrint))
  }
}

object PostResponseJsonProtocol extends DefaultJsonProtocol with SprayJsonSupport with NullOptions {
  import org.akka_starter.models.user.UserJsonProtocol._
  implicit val postResponseResponseFormat: RootJsonFormat[PostResponse] = jsonFormat2(PostResponse)
}