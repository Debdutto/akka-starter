package org.akka_starter.models.user

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

/**
  * User Model Case Class
  * @param user_id User ID
  * @param name Do we really need to tell you?
  * @param age Seriously? Are you even human if you don't understand what age is.
  * @@soundtrack Shiva - The Down Troddence
  */
case class User
(
  user_id: String,
  name: String,
  age: Int
) {
  require(!user_id.isEmpty, "You must have ID, or you can't enter the zion!")
  require(!name.isEmpty, "What's in a name? No? Well, guess what?")
  require(age.isValidInt && age < 150, "Humans don't live that long, Or do they?")
  require(age.isValidInt && age > 0, "Hole on to your horses, you don't even exist yet.")
}

/**
  * User JsonProtocol for SprayJson
  *
  * @@soundtrack Nagavalli - The Down Troddence
  */
object UserJsonProtocol extends DefaultJsonProtocol with SprayJsonSupport {
  // The order is important here. Nested property formats to be defined before parents
  implicit val userFormat: RootJsonFormat[User] = jsonFormat3(User)
}