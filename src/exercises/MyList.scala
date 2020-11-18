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
}

// ??? this guy return Nothing

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = " "
}


class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {


  val listOfIntegers: MyList[Int] = new Cons(2, new Cons(3, new Cons(4, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", new Cons("!", Empty)))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  //  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  //  println(list.tail.tail.head)
  //  println(list.add(5).head)
  //  println(list.isEmpty)
  //
  //  println(list.toString)
}