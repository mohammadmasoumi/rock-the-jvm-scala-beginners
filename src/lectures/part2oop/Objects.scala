package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static").


  // class-level functionality - we should do sth without relying on instance
  object Person {
    // "static"/"class" - level functionality
    val N_EYES: Int = 2

    def canFly: Boolean = false

    def from(mother: Person, father: Person): Person = new Person("Bobbie")

    // constructor
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality

  }

  // THE PATTERN: COMPANION (separating class-level functionality and instance-level functionality)

  val mary = new Person("Mary")
  val john = new Person("John")

  val Bobbie = Person(mary, john) // pattern


  // return False
  println(mary == john)


  // Scala object = SINGLETON INSTANCE
  val person1 = Person
  val person2 = Person

  println(Person.N_EYES)
  println(Person.canFly)
  println(person1.N_EYES)
  println(person1.canFly)

  println(person1 == person2)


}


