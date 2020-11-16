package exercises

abstract class MyList {
  /*
    head = first element of the list
    tail = reminder of the list
    isEmpty = is this list empty
    add(Int) => new List with this element added
    toString = string representation of the list
   */
  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(element: Int): MyList

  def printElements: String

  override def toString: String = "[" + printElements + "]"
}

// ??? this guy return Nothing

object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException

  override def tail: MyList = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = new Cons(element, Empty)

  def printElements: String = " "
}


class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(element: Int): MyList = new Cons(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {

  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  println(list.tail.tail.head)
  println(list.add(5).head)
  println(list.isEmpty)

  println(list.toString)
}