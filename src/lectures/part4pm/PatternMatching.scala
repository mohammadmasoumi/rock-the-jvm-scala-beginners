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

  val animal: Animal = new Dog("k9")

  //  animal match {
  //    case
  //  }


}
