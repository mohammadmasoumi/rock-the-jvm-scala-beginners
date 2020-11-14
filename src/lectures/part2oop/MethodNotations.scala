package lectures.part2oop

object MethodNotations extends App {


  class Person(val name: String, favoriteMovie: String, age: Int = 10) {
    def likes(movie: String): Boolean = favoriteMovie == movie

    def hangOutWith(person: Person): String = s"$name is hanging out with ${person.name}"

    def learns(name: String): Unit = println(s"${this.name} learns $name")

    def learnsScala: Unit = learns("Scala")

    def +(person: Person): String = s"$name is hanging out with ${person.name}"

    def +(title: String): Person = new Person(f"$name $title", favoriteMovie)

    def unary_! : String = s"$name, what the heck?" // put space between ":" and "method name"

    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I'm $age and I like $favoriteMovie"

    def apply(times: Int): String = s"$name watched $favoriteMovie $times times"

    override def toString: String = s"Hello, my name is $name and I'm $age and I like $favoriteMovie"
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


  /*
    Assignments

     1. Overload the + operator
        mary + "the rockerstar" => new person "Mary (the rockstar)"
     2. Add an age to the person class
        Add a unary + operator => new person with the age + 1
        +mary => mary with the age incrementer
     3. Add a "learns" method in the Person class => "Mary learns Scala"
        Add a leansScala method, calls learns method with "Scala"
     4. Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times"

   */
  println((mary + "the rockstar").name)
  println(mary + "the rockstar")

  println(mary)
  println(+mary)
  println(mary.unary_+) // equivalent
  println(+(mary + "the rockstart"))


  mary.learns("Scala")
  mary learns "Scala"
  mary.learnsScala
  mary learnsScala // equivalent

  println(mary(2))
  println(mary.apply(2)) // equivalent

}
