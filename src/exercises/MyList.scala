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

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]
}

// ??? this guy return Nothing

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = " "

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

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

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons[B](transformer.transform(h), t.map(transformer))

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  override def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h, t ++ list)

}


trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
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

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }))

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }))

  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }))


  //  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  //  println(list.tail.tail.head)
  //  println(list.add(5).head)
  //  println(list.isEmpty)
  //
  //  println(list.toString)
}