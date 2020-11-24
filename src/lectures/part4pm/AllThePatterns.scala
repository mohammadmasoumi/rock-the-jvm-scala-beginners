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

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  println(matchAnyThing)

  // 3. tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"Half match $something"
  }
  println(matchATuple)

  val aNestedTuple = (1, (1, 2))
  val matchANestedTuple = aNestedTuple match {
    case (firstElement, (firstNestedElement, secondNestedElement)) =>
      s"($firstElement, ($firstNestedElement, $secondNestedElement))"
    case _ => "Nothing"
  }
  println(matchANestedTuple)


}
