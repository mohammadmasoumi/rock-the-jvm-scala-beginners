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

  // Imperative programming focuses on describing how a program operates.
  // Bunch of commands to change the state of an application
  // side effects: println(), whiles, reassigning

  // Declarative programming which focuses on what the program should accomplish without specifying
  // how the program should achieve the result.

  // code blocks
  // THIS GUY IS AN EXPRESSION
  // THE VALUE OF THIS GUY IS THE VALUE OF LAST EXPRESSION
  // THE TYPE OF THIS GUY IS THE TYPE OF LAST EXPRESSION
  // CODE BLOCKS SCOPE
  val aCodeBlock = {
    val y = 2
    val z = 2
    if (z > 2) "Hello I'm Z" else "Bye"
  }

  // z isn't declared in this scope
  println(aCodeBlock)

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
