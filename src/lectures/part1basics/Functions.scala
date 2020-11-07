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
  def factorial(num: Int): Int = {
    if (num == 1) 1 else num * factorial(num - 1)
  }
  println(factorial(5))

  def fibonacci(num: Int): Int = {
    if (num == 1) 1 else if (num == 2) 1 else if (num == 3) 2 else fibonacci(num - 1) + fibonacci(num -2)

  }
  println(fibonacci(4))

}
