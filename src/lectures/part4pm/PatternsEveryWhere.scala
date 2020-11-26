package lectures.part4pm

object PatternsEveryWhere extends App {

  // big idea #1
  try {
    // code
  } catch {
    case e: RuntimeException => "Runtime"
    case npe: NullPointerException => "NullPointException"
    case _ => "Other exception"
  }

  // CATCHES ARE ACTUALLY MATCHES
  /*
  try {
    // code
  } catch (e) {
    e match {
      case e: RuntimeException => "Runtime"
      case npe: NullPointerException => "NullPointException"
      case _ => "Other exception"
    }
  }
   */

  // big idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x
  println(evenOnes)

  // generators are also base on PM
  val myTuples = List((1, 2), (3, 4))
  val filterTuples = for (
    (first, second) <- myTuples
  ) yield first * second
  println(filterTuples)

  // big idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple // like python
  println(s"a: $a, b: $b, c: $c")

  // multiple value definitions based on PATTERN MATCHING
  // ALL THE POWER ARE AVAILABLE

  val head :: tail = list
  println(s"head: $head, tail: $tail")

  // nig idea #4 - NEW
  // partial function based on pattern matching
  val mappedList = list.map {
    case v if v % 2 == 0 => v + "is even"
    case 1 => "The One"
    case _ => "default"
  } // pattern matching anonymous function or partial function literal
  mappedList.foreach(println)
  // equivalent

  val mappedList2 = list.map(x => x match {
    case v if v % 2 == 0 => v + "is even"
    case 1 => "The One"
    case _ => "default"
  })
  mappedList2.foreach(println)



}
