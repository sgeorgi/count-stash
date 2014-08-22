package de.sgeorgi.countstash

import java.net.InetSocketAddress

import akka.actor.{Actor, ActorLogging, Props}
import akka.io.Tcp.{Bind, Received, Register}
import akka.io._
import akka.util.ByteString

class Server extends Actor with ActorLogging {

  import context.system

  IO(Tcp) ! Bind(self, new InetSocketAddress("localhost", 8081))

  def receive = {

    case Tcp.Connected(remote, local) =>
      val serverWorker = context.actorOf(Props[ConnectionHandler])
      sender ! Register(serverWorker)
      log info s"Client from ${remote.getHostString} connected"

    case Tcp.Bound(localAddress) =>
      log info s"Server bound to local address $localAddress"

    case Tcp.CommandFailed(cmd) =>
      log warning s"TCP Command failed: $cmd"
  }

}

class ConnectionHandler extends Actor with ActorLogging {
  def receive = {

    case Received(data) =>
      /* Handled off to MessageDecoder and send the resulting Message to ourself */
      self ! MessageDecoder(data)

    case Command.TerminateHandler =>
      log info s"Client want's to disconnect, stopping ConnectionHandler"
      context stop self

    case data: ByteString =>
      log info s"Received data '$data'"

  }
}