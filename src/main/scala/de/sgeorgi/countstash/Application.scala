package de.sgeorgi.countstash

import akka.actor.{ActorSystem, Props}

object Application extends App {
  val actorSystem = ActorSystem("count-stash")
  val serverActor = actorSystem.actorOf(Props(classOf[Server]), "server")

}
