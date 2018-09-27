package org.akka_starter.modules.logger

/**
  * LogType Enum of four types of Logs {ERROR, WARN, DEBUG, INFO}
  *
  * @@soundtrack Pink Noise Waltz - Diablo Swing Orchestra
  */
object LogType extends Enumeration {
  type Type = Value
  val ERROR, WARN, DEBUG, INFO = Value
}
