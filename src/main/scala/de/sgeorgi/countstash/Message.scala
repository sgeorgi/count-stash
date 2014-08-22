package de.sgeorgi.countstash

import akka.util.ByteString

trait Message

object Event {

  case class HandshakeRequest(shaker: String) extends Message

  case class UnknownMessage(bs: ByteString)

  case object ConnectionClosed extends Message

}

object Command {

  case object TerminateHandler

}

object MessageDecoder {
  def apply(bs: ByteString) = {
    /* Guard for CTRL-C do handle disconnecting from the testing console */
    if (bs == ByteString(-1, -12, -1, -3, 6)) Command.TerminateHandler
    else {
      Event.UnknownMessage(bs)
    }
  }
}

object MessageCoder {
  def apply(bs: ByteString): Message = Event.HandshakeRequest(bs.toString())
  def apply(m: Message): ByteString = ByteString("whatever")
}

