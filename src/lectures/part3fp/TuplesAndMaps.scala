package lectures.part3fp

object TuplesAndMaps extends App {


  /*
    tuples - finite ordered "List"

   */

  val aTuple: Tuple2[Int, String] = new Tuple2[Int, String](2, "Hello, Scala")
  println(aTuple)

  // Syntactic sugar
  val aSyntacticSugarTuple: (Int, String) = (2, "Hello, Scala")
  println(aSyntacticSugarTuple)

  // more syntactic sugar
  val moreSyntacticSugarATuple = 2 -> "Hello, Scala"
  println(moreSyntacticSugarATuple)

  // functions on Tuples
  println(aTuple._1) // indexed access
  println(aTuple.copy(_2 = " Updated Hello Scala"))
  println(aTuple.swap) // ("Hello, Scala", 2)

  /*
    Maps key -> value
   */
  val aMap: Map[String, Int] = Map() // an empty map
  val aPhonebook: Map[String, Int] = Map(("Mohammad", 1234), ("Daniel", 456)).withDefaultValue(-1)
  val anotherPhonebook: Map[String, Int] = Map("Mohammad" -> 1234, "Daniel" -> 456)

  println(aMap)
  println(aPhonebook)
  println(anotherPhonebook)

  // map ops
  println(aPhonebook.contains("Mohammad"))
  println(aPhonebook("Mohammad"))

  // println(aPhonebook("Mary")) // throw NoSuchElementException - Not at all, I think you miss the point
  // solution? define a default value
  println(aPhonebook("Mary")) // default value or throwing exception

  // add a pairing
  val newPairing = "Mary" -> 235
  val newPhonebook = aPhonebook + newPairing
  println(newPhonebook)

  // functions on Map - map, flatMap, filter
  println(newPhonebook.map(pair => pair. _1.toLowerCase -> pair._2)) // pair

}
