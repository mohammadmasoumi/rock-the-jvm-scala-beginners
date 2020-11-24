package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match { // Here return type is String
    case 1 => "the one"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // _ = WILDCARD
  }

  println(x)
  println(description)

  // check the return type!
  val checkReturnTypes = x match {
    case 1 => 1
    case 2 => null
    case 3 => None
    case 4 => Some(4)
    case 5 => "String!"
    case 6 => List(1, 2, 3, 4)
    case 7 => Map(x -> s"X is: $x")
    case _ => Tuple1("Mohammad")
  }
  println(x)
  println(checkReturnTypes)

  // 1. decompose values (specially in conjunction with case classes)
  case class Person(name: String, age: Int)

  val mohammad = Person("Mohammad", 24)

  /*
    Keep in mind:

      1. Cases are match in order.
      2. What if no cases match? MatchError
      3. What is the type of PM expression? Unifying all types and return the lowest common ancestor
      4. PM works really well with the case classes.
   */
  val greeting = mohammad match {
    // Guard => if age < 25
    case Person(name, age) if age < 25 => s"Hi my name is $name and I'm $age years old and I enjoy learning Scala."
    case Person(name, age) => s"Hi my name is $name and I'm $age years old."
    case _ => "I don't know who I am"
  }

  println(mohammad)
  println(greeting)

  // 2. PM on sealed hierarchies
  sealed class Animal

  case class Dog(bread: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("k9")

  animal match {
    case Dog(someBread) => println(s"Matched a dog of the $someBread")
  }

  // match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  } // Why would you do that? OVER KILL
  val isEvenCond = if (x % 2 == 0) true else false // ??
  val normalIsEven = x % 2 == 0 // return to your root
  println(normalIsEven)

  /*
    Exercise
      simple function uses PM
        take an expression and return human readable form

        Sum(Number(2), Number(3)) => 2 + 3
        Sum(Sum(Number(2), Number(3)), Number(4)) => 2 + 3 + 4
        Prod(Sum(Number(2), Number(1)), Number(3)) => 2 * 1 + 3
   */

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(s1: Expr, s2: Expr) extends Expr

  case class Prod(s1: Expr, s2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(s1, s2) => show(s1) + " + " + show(s2)
    case Prod(s1, s2) => {
      def maybeShowParenthesis(exp: Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }

      maybeShowParenthesis(s1) + " * " + maybeShowParenthesis(s2)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Prod(Sum(Number(2), Number(1)), Sum(Number(3), Number(4)))))


}
