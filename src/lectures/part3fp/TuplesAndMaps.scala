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

}
