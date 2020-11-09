package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  // java functions
  println(str.charAt(2))
  println(str.codePointAt(10))
  println(str.concat("Mohammad"))
  println(str.substring(7, 11)) // inclusive, exclusive indexes
  println(str.split(" "))
  println(str.startsWith("Hello"))
  println(str.endsWith("Scala"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length) // parameter less function

  // scala functions
  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  // prepending and pending f.g: 1 +: List(2, 3) :+ 4
  println('a' +: aNumberString :+ 'z') // +: binds to right and :+ binds to left
  println(str.reverse)
  println(str.take(2)) // take 2 characters from the string

  // Scala specific: String interpolator.

  val name: String = "Mohammad"
  val age: Int = 24

  // S-interpolator
  val greeting = s"Hello, my name is $name and I am $age years old."
  // injecting string without concatenating
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."

  println(greeting)
  println(anotherGreeting)

  // F-interpolator
  val speed = 1.2F // we should put F at the end otherwise double
  val myth = f"$name can eat $speed%2.2f burgers per minute." // similar to printf method

  println(myth)

  // Can check type correctness
  val x: Float = 1.1F
  //  val aString: String = f"$x%3d" // found: float, required: int // Compile error

  // raw-interpolator
  println(raw"This a \n newline")
  val escaped: String = "This a \n newline"
  println(raw"$escaped") // ignore escaped characters inside injected parameters

}
