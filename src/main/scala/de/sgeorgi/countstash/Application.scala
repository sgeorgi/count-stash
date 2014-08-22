package de.sgeorgi.countstash

import akka.actor.{ActorSystem, Props}
import de.sgeorgi.countstash.Message._
import de.sgeorgi.countstash.server.ServerActor

object Application extends App {
  val actorSystem = ActorSystem("count-stash")
  val serverActor = actorSystem.actorOf(Props(classOf[ServerActor]), "server")
  serverActor ! Command.InitializeServer
}
