package lectures.part4pm

import exercises.{Cons, Empty, MyList}

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

  // PM can be NESTED!
  val aNestedTuple = (1, (1, 2))
  val matchANestedTuple = aNestedTuple match {
    case (firstElement, (firstNestedElement, secondNestedElement)) =>
      s"($firstElement, ($firstNestedElement, $secondNestedElement))"
    case _ => "Nothing"
  }
  println(matchANestedTuple)

  // 4. case classes - constructor pattern
  // PM can be nested with CCs as well
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, tail)) => s"$head, $subhead, $tail" // Nested!
  }
  println(matchAList)

  // 5. list patterns
  val aStandardList = List(1, 2, 3, 4)
  val aStandardListMatching = aStandardList match {
    case List(1, _, _, _) => "Extractor" // extractor - advanced
    case List(1, _*) => "Var Args" // var arg pattern
    case 1 :: List(_) => "Infix pattern" // infix pattern
    case List(1, 2, 3) :+ 4 => "Infix pattern too!" // infix pattern
  }
  println(aStandardListMatching)

  // 6. type specification
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case myList: List[Int] => "Explicit type specification"
    case _ => "Any"
  }

  // 7. name binding
  val nameBindingMatch = aList match {
    // name binding => use the name later(there)
    case nonEmptyList@Cons(_, _) => s"This is name binding $nonEmptyList"
    // name binding inside nested patterns
    case Cons(1, rest@Cons(2, _)) => s"$rest"
  }

  // 8. multi-patterns
  val multiPattern = aList match {
    case a@(Empty | Cons(1, Cons(2, _))) => s"multi-patterns with pipe | $a"
  }

  // 9. If guards
  val secondElementSpecial = aList match {
    case myCons@Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 => f"$myCons"
  }


  // ALL

  /*
    Exercise.
   */

  // Surprised!
  val numbers = List(1, 2, 3, 4)
  val numbersMatch = numbers match {
    case listOfString: List[String] => "a list of string" // JSM trick
    case listOfNumbers: List[Int] => "a list of Int"
    case _ => "Something else!"
  }
  //  val numbersMatch1 = numbers match {
  //    case listOfString => "a list of string" // JSM trick
  //    case listOfNumbers => "a list of Int"
  //    case _ => "Something else!"
  //  }

  println(numbersMatch)

}
