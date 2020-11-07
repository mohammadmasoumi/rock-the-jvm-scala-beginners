package lectures.part1basics

object ValuesVariablesTypes extends App {


  // VALs ARE IMMUTABLE
  val x: Int = 42
  // x = 2 ... COMPILER ERROR

  // THE TYPES OF VALs ARE OPTIONAL
  // COMPILER CAN INFER TYPES
  val y = 42
  // val x: Int = "Hello, scala" ... COMPILER CONFUSED

  val aString = "Hello, Scala"
  val anotherString: String = "Goodbye"
  val aBoolean: Boolean = false
  val anotherBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = 32
  val aShort: Short = 23232 // COMPILER WILL COMPLAIN IF THE NUMBER IS TOO BIG
  val aLong: Long = 21232323434L // 8 BITs INSTEAD OF 4 BITs
  val aFloat: Float = 2.3F // F AT THE END INDICATES IT'S FLOAT
  val aDouble: Double = 2.2

  // VARIABLES
  // WORKING LESS WITH VARIABLES IN FUNCTIONAL PROGRAMMING
  // WE ELIMINATE SIDE EFFECTS IN FUNCTIONAL PROGRAMMING
  var aVariable = 2
  aVariable = 3 // side effects(functional programming)

  // SIDE EFFECTS
  // * CHANGING VARIABLES
  // * PRINTING ON THE SCREEN
  // * ...
  println(aVariable) // THIS IS A SIDE EFFECT

}
