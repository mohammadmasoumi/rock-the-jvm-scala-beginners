package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  // a function
  def aFunction(a: String, b: Int): String = {
    a + " " + b // String concatenation
  }

  println(aFunction("Hello", 23))

  // aParameterless function
  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  // Recursive function
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello", 3))

  // Side effects
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  aFunctionWithSideEffects("Side Effects")

  // Auxiliary functions
  def anOuterFunction(firstInt: Int, secondInt: Int): Int = {
    def anInnerFunction(innerFirstInt: Int): Int = {
      42 * innerFirstInt
    }

    anInnerFunction(secondInt + firstInt)
  }

  println(anOuterFunction(32, 21))

  /*
    Assignments
   */

  // a greeting function
  def aGreetingFunction(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old."

  println(aGreetingFunction("Mohammad", 24))

  // Calculate factorial
  def factorial(aNumber: Int): Int = {
    if (aNumber <= 1) 1
    else aNumber * factorial(aNumber - 1)
  }

  println(factorial(5))

  // Calculate fibonacci
  def fibonacci(aNumber: Int): Int = {
    if (aNumber <= 2) 1
    else fibonacci(aNumber - 1) + fibonacci(aNumber - 2)
  }

  println(fibonacci(4))

  // Is prime
  def isPrime(aNumber: Int): Boolean = {
    def innerFunc(t: Int): Boolean = {
      if (t <= 1) true
      else aNumber % t != 0 && innerFunc(t - 1)
    }

    innerFunc(aNumber / 2)
  }

  println(isPrime(3))

  // Is prime with tail recursion
  def isPrimeTailRecursion(aNumber: Int): Boolean = {
    @tailrec
    def cumulativeRecursion(t: Int, isPrime: Boolean = true): Boolean =
      if (t <= 1) isPrime
      else cumulativeRecursion(t - 1, aNumber % t != 0)

    cumulativeRecursion(aNumber / 2)
  }

  println(isPrimeTailRecursion(4))

}
