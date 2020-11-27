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

  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  val threeNonPrimitiveElements = Array.ofDim(3) // allocation space for 3 elements

  threeElements.foreach(println) // filled with zeros
  threeNonPrimitiveElements.foreach(println) // filled with nulls

  // mutable
  numbers(2) = 10 // quite rarely use in practice
  println(numbers.mkString("-"))

  // arrays and seq - Deep rabbit hole
  val arrayToSeq: Seq[Int] = numbers // an implicit conversion
  println(arrayToSeq)

  /*
    Vectors
      - effectively constant indexed read and write: O(log32(n))
      - fast element addition: append/prepend
      - implemented as a fixed-branched trie (branch factor 32)
      - good performance for large sizes
   */

  val noElements = Vector.empty
  val vectorNumbers = noElements :+ 1 :+ 2 :+ 3
  val modified = numbers updated(0, 10)

  println(vectorNumbers)
  println(modified.mkString("|-|"))

  val vector: Vector[Int] = Vector(1, 2, 3)

  // vectors vs lists performance

}
