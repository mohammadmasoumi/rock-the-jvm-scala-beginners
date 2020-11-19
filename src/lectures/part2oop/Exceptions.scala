package lectures.part2oop

object Exceptions extends App {


  val x: String = null
  // println(x.length)
  // this will crash with a NPE

  // 1. throwing exceptions

  //  throw new NullPointerException // this is an expression
  //  val aWeirdValue: String = throw new NullPointerException // Nothing a valid substitute for anything

  // 2. catching exceptions

  def getInt(withException: Boolean): Int =
    if (withException) throw new RuntimeException("No int for you")
    else 42

  try {
    // code that might throw exception

    getInt(true)
  } catch {
    case e: NullPointerException => println(s"Catch a NullPointException! | $e")
    case e: RuntimeException => println(s"Catch a RunTimeException! | $e")

  } finally {
    // code that will get executed NO MATTER WHAT
    println("Finally ")
  }

  // write custom exception class
  class MyException extends Exception

  val exception = new MyException

  //  throw exception

  /*
    Assignments:

      1. Crash your program with an OutOfMemoryError
      2. Crash your program with an SOError
      3. PocketCalculator
        - add(x,y)
        - subtract(x,y)
        - multiply(x,y)
        - divide(x,y)

        Throw:
          - OverFlowException if add(x,y) exceeds Int.MAX_VALUE
          - UnderFlowException if subtract(x,y) exceeds Int.MIN_VALUE
          - MatchCalculationException for division by 0
   */

  // 1. Crash your program with OutOfMemoryError
  //  throw OutOfMemoryError

  def infiniteLoop(n: String): String =
    if (n.length == 100000000000000L) n
    else infiniteLoop(n * 10)

  // infiniteLoop("MohammadMasoumi")

  // OOM
  // val array = Array.ofDim(Integer.MAX_VALUE)

  // 2. Crash your program with SOError

  def fibonacci(number: Int): Int =
    if (number <= 2) 1
    else fibonacci(number - 1) + fibonacci(number - 2)

  //  throw StackOverflowError
  //  println(fibonacci(50000))

  //  println(s"ZeroDivision:  ${2 / 0}") it'll raise ArithmeticException

  // 3. PocketCalculator

  class OverFlowException(message: String = "OverFlowException") extends Exception(message)

  class UnderFlowException(message: String = "UnderFlowException") extends Exception(message)

  class MatchCalculationException(message: String = "MatchCalculationException") extends Exception(message)

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverFlowException()
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException()
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y

      if (x > 0 && y < 0 && result < 0) throw new OverFlowException()
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException()
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y

      if (x > 0 && y > 0 && result < 0) throw new OverFlowException()
      else if (x < 0 && y < 0 && result < 0) throw new OverFlowException()
      else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException()
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException()
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MatchCalculationException("Division by zero")
      else x / y
    }
  }

  //  println(PocketCalculator.add(Int.MaxValue, 10))
  //  println(PocketCalculator.subtract(-Int.MaxValue, Int.MaxValue))
  //  println(PocketCalculator.multiply(Int.MaxValue, Int.MaxValue))
  //  println(PocketCalculator.divide(Int.MaxValue, Int.MaxValue))

}

