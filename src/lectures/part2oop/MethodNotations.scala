package lectures.part2oop

object MethodNotations extends App {


  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = favoriteMovie == movie

    def hangOutWith(person: Person): String = s"$name is hanging out with ${person.name}"

    def +(person: Person): String = s"$name is hanging out with ${person.name}"

    def unary_! : String = s"$name, what the heck?" // put space between ":" and "method name"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation (syntactic sugar)
  // works with methods with only single parameter

  // "operators" in Scala
  val tom = new Person("Tom", "Fight club")
  println(mary hangOutWith tom) // like operations
  print(mary + tom)

  // mathematical operators are methods too!
  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS.
  // Akka actors have ! ?

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_- // equivalent
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive) // rarely use in practice 

  // apply method
  println(mary.apply())
  println(mary()) // equivalent
  // instance is called --> compiler will call apply method in the class definition
}
