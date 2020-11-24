package lectures.part4patterns

import scala.util.Random

/*
Imperative programming:

  In computer science, imperative programming is a programming paradigm that uses statements
  that change a program's state. In much the same way that the imperative mood in natural languages
  expresses commands, an imperative program consists of commands for the computer to perform.
 */

object Options extends App {
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // Options are invented to deal with UNSAFE APIs.

  // unsafe APIs
  def unsafeMethod(): String = null

  // val result = Some(unsafeMethod()) // WRONG: Some(null) -> break the whole point
  val result = Option(unsafeMethod()) // we don't need to check for null
  println(result)

  // chained method
  def backupMethod() = "A valid result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  /*
    Design APIs to return null
   */
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterBackupMethod() orElse betterBackupMethod()

  def playgroundBackupMethod(): Option[String] = Some("A valid result!") // we should use `Some`

  println(betterChainedResult)

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE, don't use it.

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // because we have map, flatMap, filter -> we will have for-comprehension
  // for-comprehension

  /*
    Exercise.
   */
  val config: Map[String, String] = Map(
    "host" -> "176.10.10.20",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // Connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // try to establish a connection, if so - print the connect method

  // first approach
  val host = config.get("host")
  val port = config.get("port")

  /*
    if (h != null)
      if (p != null)
        return Connection(h, p)
    return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection(host = h, port = p)))
  /*
    if (c != null)
      return c.connect
    return null
   */
  val connectStatus = connection.map(c => c.connect)
  // if (connectionStatus == null) println(None) else println(Some(connectionStatus.get))
  println(s"Connection status: $connectStatus")
  /*
    if (connectionStatus != null)
      println(connectionStatus)
   */
  connectStatus.foreach(println)

  // chain calls
  config.get("host")
    .flatMap(h => config.get("port")
      .flatMap(p => Connection(h, p))
      .map(connection => connection.connect))
    .foreach(println)

  // for-comprehension
  val forConnectionStatus = for (
    host <- config.get("host");
    port <- config.get("port");
    connection <- Connection(host, port)
  ) yield connection.connect
  forConnectionStatus.foreach(println)


}
