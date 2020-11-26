package lectures.part3fp

object MapFlatMapFilterFor extends App {

  val newList = List(1, 2, 3) // calling apply method

  println(newList)
  println(newList.head)
  println(newList.tail)

  // map
  println(newList.map(_ + 2))
  println(newList.map(_ + "-Hello"))

  // filter
  println(newList.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(newList.flatMap(toPair))

  /*
    Exercise
      1. print all combinations between two list
  */


  val intList: List[Int] = List(1, 2, 3)
  val charList: List[Char] = List('a', 'b', 'c')
  val colorList: List[String] = List("Red", "Blue")

  def combination[A, B](firsList: List[A], secondList: List[B]): List[String] =
    firsList.flatMap(firstElem => secondList.map(secondElem => s"$firstElem-$secondElem"))

  combination(intList, charList).foreach(println)

  // iterating
  intList.flatMap(a => charList.map(b => s"$a-$b")).foreach(println)
  intList.flatMap(a => charList.flatMap(b => colorList.map(c => s"$a-$b-$c"))).foreach(println)

  // foreach
  newList.foreach(println)

  // for-comprehension
  // for-comprehension is rewritten to the chain of map, flatMap and filter by the COMPILER
  val forComprehension = for {
    a <- intList
    b <- charList
    c <- colorList
  } yield s"$a-$b-$c"
  println(forComprehension)

  // for-comprehension with guards
  val forComprehensionWithGuards = for {
    integer <- intList if integer % 2 == 0
    character <- charList if character == 'a'
    color <- colorList if color == "Red"
  } yield s"$integer-$character-$color"
  println(forComprehension)

  // equivalent
  intList
    .filter(_ % 2 == 0)
    .flatMap(a => charList
      .flatMap(b => colorList
        .map(c => s"$a-$b-$c")))
    .foreach(println)

  // syntax overload
  println(newList.map {
    x =>
      x * 2
  })

  /*
  Exercise
    1. MuList support for comprehension
    2. A small collection of at most ONE element - Maybe[+T]
      - map, flatMap, filter
   */


}
