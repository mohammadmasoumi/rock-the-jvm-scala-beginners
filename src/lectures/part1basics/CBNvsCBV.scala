package lectures.part1basics

object CBNvsCBV extends App {


  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // => Call by name
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  // pass the value of the function instead of function
  calledByValue(System.nanoTime())
  // pass the function
  calledByName(System.nanoTime())

  // lazy evaluation
  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int): Unit = println(x)

  // This one will throw stackOverflow exception
  //  printFirst(infinite(), 34)

  printFirst(34, infinite())

}
