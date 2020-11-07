package lectures.part1basics

object Functions extends App {


  // a function
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 23))

  // Paramerterless function
  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  // Recursive function
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello", 3))

  def anOuterFunction(firstInt: Int, secondInt: Int): Int = {
    def anInnerFunction(innerFirstInt: Int): Int = {
      42 * innerFirstInt
    }
    anInnerFunction(secondInt + firstInt)
  }

  println(anOuterFunction(32, 21))

  // Assignments
  // a greeting function
  def aGreetingFunction(name: String, age: Int): String = "Hi, my name is " + name + " and I am " + age + " years old."
  println(aGreetingFunction("Mohammad", 24))

  // calculate factorial of a number
  def factorial(num: Int): Int = {
    if (num == 1) 1 else num * factorial(num - 1)
  }
  println(factorial(5))

  // fibonacci
  def fibonacci(num: Int): Int = {
    if (num == 1) 1 else if (num == 2) 1 else if (num == 3) 2 else fibonacci(num - 1) + fibonacci(num -2)

  }
  println(fibonacci(4))

  // prime number
  def isPrime(num: Int): Boolean = {
    if (num == 1) false else {
      def innerIsPrime(aNum: Int, aDivider: Int): Boolean = {
        if (aDivider == 1) true else if (aNum % aDivider == 0) false else innerIsPrime(aNum, aDivider - 1)
      }
      innerIsPrime(num, num - 1)
    }
  }

  println(isPrime(3))




}
