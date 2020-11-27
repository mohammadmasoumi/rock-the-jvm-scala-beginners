package lectures.part3fp

object Sequences extends App {


  /*
    Seq - general interface for data structures
      - have a well defined order
      - can be indexed

    Support various operation
      - apply, iterator, length, reverse, indexing, reversing
      - concatenation, appending, prepending
      - grouping, sorting, zipping, searching, slicing
   */

  // Seq
  val aSequence = Seq(1, 2, 3, 4) // apply constructor -> can apply other subtypes
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2)) // apply method
  println(aSequence ++ Seq(5, 6, 7))


}
