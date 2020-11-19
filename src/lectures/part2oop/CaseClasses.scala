package lectures.part2oop

object CaseClasses extends App {

  /*
    boiler plates
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim: Person = new Person("Jim", 34)
  println(jim.name, jim.age)

  // 2. sensible toString
  println(jim.toString)
  println(jim) // equivalent
  // println(instance) == println(instance.toString) // syntactic sugar

  // 3. equals and hashCode implemented OOTB (out of the box)
  val anotherJim = new Person("Jim", 34)
  println(jim == anotherJim) // just because of jim

  // 4. CCs have handy copy method
  val jim3: Person = anotherJim.copy()
  val jim4: Person = anotherJim.copy(age = 44)

  println(anotherJim == jim4)

  // 5. CCs have COMPANION objects
  val thePerson = Person
  val mary: Person = Person("Mary", 33) // CC apply method


  // 6. CCs are serializable
  // Akka -> sending serializable messages in network

  // 7. CCs have extracted pattern = CCs can be used in PATTERN MATCHING

  case object UK {
    def name: String = "The UK of GB and NL"
  }


}
