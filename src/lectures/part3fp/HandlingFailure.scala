package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}


object HandlingFailure extends App {

  // create success and failure

  val aSuccess = Success(3) // Companion pattern
  val aFailure = Failure(new RuntimeException("SUPER FAILURE!"))
  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER")

  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)


  // syntactic sugar
  val anotherPotentialFailure = Try {
    // the code that might throw
  }

  // utilities
  println(potentialFailure.isSuccess)
  println(potentialFailure.isFailure)

  // orElse
  def backupMethod(): String = "A valid result"

  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  val betterFallbackTry = Try(unsafeMethod()) orElse Try(backupMethod())
  println(fallbackTry)
  println(betterFallbackTry)

  // If you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)

  def betterBackupMethod(): Try[String] = Success("A valid result")

  def aBetterFallback: Try[String] = betterUnsafeMethod() orElse betterBackupMethod()

  println(s"aBetterFallback: $aBetterFallback")

  def safeFallback: Try[String] = betterBackupMethod() orElse betterBackupMethod()

  println(s"safeFallback: $safeFallback")

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10)) // change success to failure

  // for-comprehension

  /*
    Exercise
   */
  val hostName = "localhost"
  val portName = "8080"

  def renderHTML(page: String): Unit = println(page)

  class Connection {

    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html> ... </html>"
      else throw new RuntimeException("Connection interruption")
    }

    def getSafe(url: String): Try[String] =
      Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] =
      Try(getConnection(host, port))
  }

  // if you get the HTML page from the connection => print it to the console, f.g call renderHTML
  val possibleConnection = HttpService.getSafeConnection(hostName, portName)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("a valid url"))
  possibleHTML.foreach(renderHTML)

  // shorthand version
  HttpService.getSafeConnection(hostName, portName)
    .flatMap(connection => connection.getSafe("url")).
    foreach(renderHTML)

  // for-comprehension
  for {
    connection <- HttpService.getSafeConnection(hostName, portName)
    page <- connection.getSafe("/home")
  } renderHTML(page)

  /*
  imperative language equivalent

  try {
    connection = HttpService.getConnection(host, port)
    try {
      page = connection.get("/home")
      renderHTML(page)
    } catch (some other exception) {
      logger.info(some other exception)
    }
  } catch (exception) {
    logger.info(exception)
  }
   */


  // My answer
  def connect(host: String, port: String): Try[Try[Unit]] = {
    Try(HttpService.getConnection(host, port)).map(
      connection => Try(connection.get(s"https://$host:$port/home")).map(println)
    )
  }

  connect(hostName, portName)
}
