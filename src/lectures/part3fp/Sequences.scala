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

  val unsortedSequence = Seq(2, 1, 3, 4, 6, 5, 9, 8, 7)
  println(unsortedSequence.sorted) // no parameter (could have parameters)

  // range -> Also is Seq
  val aRange: Seq[Int] = 1 to 10 // inclusive
  aRange.foreach(println)

  // until
  val aRangeWithUntil = 1 until 10 // exclusive
  aRangeWithUntil.foreach(println)

  // do sth 10 times
  (1 to 10).foreach(println)

  /*
    List - A LinearSeq immutable linked list
      - head, tail, isEmpty methods are fast O(1)
      - most operations are O(n)L length, reverse

    Sealed - ahas two subtypes
      - object Nil (empty)
      - class :: (Like the Cons in MyList)
   */

  // prepending and appending
  val aList = List(1, 2, 3, 4)
  val prepended = 42 :: aList
  val anotherPrepended = 42 +: aList :+ 42 // colon is always on the side of list
  val appended = aList :+ 42

  println(prepended)
  print(anotherPrepended)
  println(appended)

  val apples5 = List.fill(5)("Hello") // curried function
  println(apples5)

  // make string
  println(aList.mkString("-"))

  /*
   Arrays - simple java arrays
    - can be manually constructed with predefined length
    - can be mutated (update in place)
    - are interoperable with java's T[] arrays
    - indexing is fast

   */



}
