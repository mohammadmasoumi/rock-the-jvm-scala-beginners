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

  println(listOfIntegers.filter(elem => elem % 2 == 0))

  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))))


  //  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  //  println(list.tail.tail.head)
  //  println(list.add(5).head)
  //  println(list.isEmpty)
  //
  //  println(list.toString)
}