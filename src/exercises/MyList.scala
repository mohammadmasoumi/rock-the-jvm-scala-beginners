package exercises

abstract class MyList[+A] {
  /*
    head = first element of the list
    tail = reminder of the list
    isEmpty = is this list empty
    add(Int) => new List with this element added
    toString = string representation of the list
   */
  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  // HOFs
  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  def fold[B](start: B)(operator: (B, A) => B): B
}

// ??? this guy return Nothing

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = " "

  // higher-order functions (HOFs)
  /*
    HOF
      - receive functions
      - return other functions as result
   */
  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  // concatenation
  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def foreach(f: Nothing => Unit): Unit = () // unit value = ()

  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length!")
    else Empty

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}


case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  /*
    [1, 2, 3].map(n * 2)
      = new Cons(2, [2, 3].map(n * 2))
      = new Cons(2, new Cons(4, [3].map(n * 2)))
      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
      = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */
  override def map[B](transformer: A => B): MyList[B] =
    new Cons[B](transformer(h), t.map(transformer))

  /*
    [1, 2].flatMap(n => [n, n+1])
    = [1, 2] ++ [2].flatMap(n => [m, n+1])
    = [1, 2] ++ [2, 3] ++ Empty.flatMap(n => [m, n+1])
    = [1, 2] ++ [2, 3] ++ Empty
    = [1, 2, 3, 4]

   */
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  /*
    [1, 2, 3].filter(n % 2 == 0)
     = [2, 3].filter(n % 2 == 0)
     = new Cons(2, [3].filter(n % 2 == 0))
     = new Cons(2, Empty.filter(n % 2 == 0))
     = new Cons(2, Empty)
   */
  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  /*
    [1, 2] ++ [3, 4, 5]
     = new Cons(1, [2] ++ [3, 4, 5])
     = new Cons(1, new Cons(2, Empty ++ [3, 4, 5]))
     = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, Empty)))))
   */
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h, t ++ list)

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) < 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length!")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))

  /*
    fold or reduce
    [1, 2, 3].fold(0)(+)
      = [2, 3].fold(1)(+)
      = [3].fold(3)(+)
      = [].fold(6)(+)
      = 6
   */
  override def fold[B](start: B)(operator: (B, A) => B): B =
    t.fold(operator(start, h))(operator)
}

object ListTest extends App {

  val listOfIntegers: MyList[Int] = new Cons(2, new Cons(3, new Cons(4, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(5, new Cons(6, new Cons(7, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(5, new Cons(6, new Cons(7, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", new Cons("!", Empty)))

  println(anotherListOfIntegers == cloneListOfIntegers)

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfStrings ++ anotherListOfIntegers)
  println(listOfIntegers ++ listOfIntegers)
  println(listOfIntegers.++(anotherListOfIntegers))

  println(listOfIntegers.map(elem => elem * 2))
  println(listOfIntegers.map(_ * 2)) // syntactic sugar

  println(listOfIntegers.filter(elem => elem % 2 == 0))
  println(listOfIntegers.filter(_ % 2 == 0)) // syntactic sugar

  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))))

  // HOFs
  listOfIntegers.foreach(println)

  println(listOfIntegers.sort((x, y) => y - x))

  println(cloneListOfIntegers.zipWith(listOfStrings, (x: Int, y: String) => s"$x-$y"))
  println(cloneListOfIntegers.zipWith[String, String](listOfStrings, _ + " " + _))

  // they are expressions as well too!
  // for-comprehension = map, flatMap, filter should be implemented!
  val myListForComprehension = for {
    aNumber1 <- listOfIntegers
    aNumber2 <- anotherListOfIntegers
    aNumber3 <- cloneListOfIntegers
    aString <- listOfStrings
  } yield s"$aNumber1-$aNumber2-$aNumber3-$aString"
  println(myListForComprehension)

  println(cloneListOfIntegers.fold(0)(_ + _))

  //  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  //  println(list.tail.tail.head)
  //  println(list.add(5).head)
  //  println(list.isEmpty)
  //
  //  println(list.toString)
}