package lectures.part1basics

object Expressions extends App {

  /*
    EXPRESSIONS:
     - THEY EVALUATE
     - HAVE THEIR OWN TYPE
   */
  val x = 1 + 2 // EXPRESSION
  println(x)

  // MATH EXPRESSIONS
  println(1 + 2 * 3) // + - * / & | ^ << >> >>> (right shift with zero extension)

  // COMPARISON EXPRESSIONS
  print(1 == x) // == != < <= > >=

  // LOGICAL EXPRESSIONS
  println(!(1 == x)) // ! && ||

  var aVariable = 3
  aVariable += 2
  println(aVariable)

  // Instruction(DO) vs Expression(COMPUTE A VALUE)
  // The Difference between Imperative and Declarative programming language

  // Imperative programming focuses on describing how a program operates.
  // Bunch of commands to change the state of an application

  // Declarative programming which focuses on what the program should accomplish without specifying
  // how the program should achieve the result.

  // SIDE EFFECTS: println(), whiles, reassigning, logging, ...

  // IF expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3 // IF expression, Return a Value
  println(aConditionValue)
  println(if (aCondition) 5 else 3)
  println(3 + 5)

  // NEVER USE IT AGAIN
  var idx = 0
  while (idx < 10) {
    println("Hello, Scala")
    idx += 1
  }

  // EVERYTHING IN SCALA IS EXPRESSION
  val aWeirdValue = (aVariable == 3) // Unit == void
  println(aWeirdValue)

  // CODE BLOCKS
  // This guy is an EXPRESSION
  // The value of this guy is the value of last EXPRESSION
  // The type of this guy is the type of last EXPRESSION
  // The code block scope -> VALUES AND VARIABLES ARE ACCESSIBLE IN THE SCOPE AREA
  val aCodeBlock = {
    val y = 2
    val z = 2
    if (z > 2) "Hello I'm Z" else "Bye"
  }

  // z isn't declared in this scope -> BLOCK SCOPE
  println(aCodeBlock)

  /*
    Assignments
   */

  // The difference between println("String") and "String"
  println("String")
  println(println("Hello"))

  val someValue: Boolean = {
    2 < 3
  }
  val anotherValue: Int = {
    if (someValue) 239 else 988
    23
  }

  println(someValue)
  println(anotherValue)
}
