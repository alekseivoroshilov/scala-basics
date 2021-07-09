package exercises

import scala.util.Try

object EstablishingConnection extends App {
  val host = "asfasfaf"
  val port = "sdsdsfsgg"
  val config: Map[String, String] = Map(("host", "sadasda"), ("port", "ffffsf"))

  class Connection {
    def connect: String = "Connected"
  }

  object Connection {
    def apply(host: String, port: String): Option[Connection] = Option(new Connection)
  }

  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect orElse(null)

    forConnectionStatus.foreach(println)


  Connection(config.get("host").get, config.get("port").get).get.connect
}
