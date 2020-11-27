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
  val aPhonebook: Map[String, Int] = Map(("Mohammad", 1234), ("Daniel", 456))
  val anotherPhonebook: Map[String, Int] = Map("Mohammad" -> 1234, "Daniel" -> 456)

  println(aMap)
  println(aPhonebook)
  println(anotherPhonebook)
}
