package lectures.part4pm

object AllThePatterns extends App {

  // 1. constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "A number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }

  // 2. math anything
  // 2.1 Wildcard

  val matchAnyThing: Unit = x match {
    case _ =>
  }

  println(matchAnyThing)

}
