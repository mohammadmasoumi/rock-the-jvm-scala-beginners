package lectures.part3fp

import scala.annotation.tailrec

object HOFsCurries extends App {

  // superFunction type: (Int, Function) => Function
  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // higher-order function (HOF)

  // map, flatMap, filter in MyList

  // function that applies a function nTimes over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(....(x))) = nTimes(f, n-1, f(x))

  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1

  println(nTimes(plusOne, 10, 1))
  println(nTimes((x: Int) => x + 1, 10, 1))
  println(nTimes(_ + 1, 10, 1)) // syntactic sugar

  // nTimesBetter(f, n) = x => f(f(f(...f(x))))
  // val increment10 = nTimesBetter(plusOne, 10) = x => plusOne(plusOne(plusOne(...plusOne(x))))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): Int => Int =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val plus10 = nTimesBetter(_ + 1, 10)
  println(plus10(1))
  println(nTimesBetter(_ + 1, 10)(1))

  // curries functions
  val superAdderFunction: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val anotherSuperAdderFunction: Int => Int => Int = (x: Int) => (y: Int) => x + y

  val adder3 = superAdderFunction(3) // y => y + 3
  println(adder3(10))

  println(superAdderFunction(10)(20))
  println(anotherSuperAdderFunction(10)(20))


  // function with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  // declaring types are important
  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  /*
    1. Expand MyList:
      - foreach method A => Unit
      - sort function ((A, B) => Int) => MyList
        [1, 2, 3].sort((x, y) => y - x) => [3, 2, 1]
      - zipWith (List, (A, B) => B) => MyList[B]
        [1, 2, 3].zipWith([4, 5, 6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4, 10, 18]
      - fold
        [1, 2, 3].fold(0)(x + y) = 6

    2. toCurry: (Int, Int) => a value
       fromCurry (Int => Int => Int) => (Int, Int) => Int

    3. compose(f, g) => x => f(g(x))
       andThen(f, g) => x => g(f(x))
   */

  def superAdder(x: Int, y: Int): Int = x + y

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def compose[A, B, T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def andThen[A, B, T](f: A => B, g: B => T): A => T =
    x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)
  def adder4 = superAdder2(4)
  println(adder4(17))

  val simpleAdder = fromCurry(x => y => x + y)
  println(simpleAdder(4, 17))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3) // (4 * 3) + 2
  val sorted = andThen(add2, times3) // (4 + 2) * 3

  println(composed(4))

  println(sorted(4))

}
