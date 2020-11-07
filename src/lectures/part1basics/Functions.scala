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


}
