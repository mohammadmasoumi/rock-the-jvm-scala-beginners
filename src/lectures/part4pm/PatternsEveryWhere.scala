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


}
