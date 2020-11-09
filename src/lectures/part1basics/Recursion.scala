package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  println(factorial(10))

  def seeFactorialResult(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + "- I first need factorial of " + (n - 1))
      val result = n * seeFactorialResult(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }

  // StackOverflow exception will be raised
  //  println(seeFactorialResult(50000))

  // Tail recursion
  def anotherFactorial(n: Int): BigInt = {

    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  println(anotherFactorial(5000))

  // another Implementation
  @tailrec
  def anotherFactorialImplementation(n: Int, accumulator: BigInt = 1): BigInt =
    if (n <= 1) accumulator
    else anotherFactorialImplementation(n - 1, n * accumulator)

  println(anotherFactorialImplementation(5000))

  /*
    Assignments

    1. Concatenate a string n times.
    2. IsPrime function tail recursive.
    3. Fibonacci function, tail recursive.
   */

  @tailrec
  def concatenateString(aString: String, n: Int): String =
    if (n == 1) aString
    else concatenateString(aString + aString, n - 1)

  println(concatenateString("Mohammad", 10))

  def isPrime(aNumber: Int): Boolean = {
    @tailrec
    def innerIsPrime(n: Int, result: Boolean = true): Boolean =
      if (n <= 1) result
      else innerIsPrime(n - 1, result && (aNumber % (n) != 0))

    innerIsPrime(aNumber / 2)
  }

  println(isPrime(32))

  def fibonacci(aNumber: Int): Int = {
    @tailrec
    def innerFibonacci(currentNumber: Int, lastAccumulative: Int, secondLastAccumulative: Int): Int =
      if (currentNumber > aNumber) lastAccumulative
      else innerFibonacci(currentNumber + 1, lastAccumulative + secondLastAccumulative, lastAccumulative)

    if (aNumber <= 2) 1
    else innerFibonacci(3, 1, 1)
  }

  println(fibonacci(7))

}
