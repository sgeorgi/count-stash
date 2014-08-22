package de.sgeorgi.countstash.server

import akka.actor.{Actor, ActorLogging}
import de.sgeorgi.countstash.Message._

class ServerActor extends Actor with ActorLogging {
  override def receive: Receive = {
    case Command.InitializeServer =>
      log.info("Server Actor initialized")
  }
}
