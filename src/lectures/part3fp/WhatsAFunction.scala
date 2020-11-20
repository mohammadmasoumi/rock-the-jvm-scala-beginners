package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use function as first class elements
  // problem: oop (originally JVM designed for)

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element + 2
  }

  println(doubler(2))

  // function types = Function[A, B]
  // scala takes up to 22 function types
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("3"))

  //  val adder: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
  //    override def apply(a: Int, b: Int): Int = a + b
  //  }
  // syntactic sugar
  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECT!

  /*
    Assignments:
      1. a function which takes 2 strings and concatenate them.
      2. transform the MyPredicate and MyTransformer to function type
      3. define an function which takes an Int and returns another function
      which takes and Int and return an Int
        - what's the type of this function
        - how to do it
   */

  val stringConcatenation: (String, String) => String =
    (firstString, secondString) => firstString + secondString

  println(stringConcatenation("Mohammad", "Masoumi"))

  val myAdder: Function1[Int, Function1[Int, Int]] =
    new Function[Int, Function1[Int, Int]] {
      override def apply(a: Int): Function1[Int, Int] =
        new Function[Int, Int] {
          override def apply(b: Int): Int = a + b
        }
    }

  // lambda
  val specialFunction: Int => Int => Int =
    a => b => a + b

  val myAdder3 = myAdder(3)
  println(myAdder3(4)) // equivalent === println(myAdder(3)(4))
  println(myAdder(3)(4))

  println(specialFunction(2)(3))

}

trait MyFunction[A, B] {
  def apply(element: A): B
}


class Action {
  def execute(element: Int): String = ???
}

trait TraitAction[A, B] {
  def execute(element: A): B = ???
}
