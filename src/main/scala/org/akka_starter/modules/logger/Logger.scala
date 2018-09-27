package org.akka_starter.modules.logger

object Logger {

  /**
    * Method to log to STDOUT
    *
    * @param statement Keyword to identify the log
    * @param message   Log Message
    * @param `type`    Type of log {'ERROR', 'WARN', 'DEBUG', 'INFO'}
    * @param tags      Tags to Identify the log
    * @param reference Reference to Identify the log
    * @@soundtrack Cut to the Chase - Cassini's Division
    */
  def log(statement: String, message: String, `type`: LogType.Type, exception: Option[Exception] = None, tags: Set[String] = Set(), reference: Map[String, String] = Map()) = {
    val ex = if(exception.isDefined) exception.get else ""
    val errorLog = List(`type`, statement, message, ex, tags.mkString(", "), reference.mkString(", "))
    println(errorLog.mkString(" : "))
  }
}


