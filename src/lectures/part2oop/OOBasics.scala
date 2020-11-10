package lectures.part2oop

object OOBasics extends App {

  // instantiation: concrete realization of memory.
  // class: organize data and code
  // class Person(name: String, age: Int)
  val person = new Person("John", 24)
  println(person.age) // class parameter not a class member
  // this will print 2(class initialization) then 24
  person.greet("Daniel")
  person.greet()

  println("person: ", person)

  // classes represent data and functionality
  // constructor
  // class parameters are NOT FIELDS
  // age and x are FIELDS, therefore we can access with dot .
  class Person(name: String, val age: Int = 24) { // default parameters work for classes too
    // body
    val x: Int = 2 // field

    // we can access to the name whether it's field or not
    def greet(name: String): Unit = println(s"${this.name} says: Hello $name")

    // method overloading: method with the same name different signature(inputs)
    // name refers to the name parameter
    def greet(): Unit = println(s"Hi, I am $name")

    // multiple constructors
    def this(name: String) = this(name, 24) // call primary constructor
    def this() = this("Mohammad Masoumi") // call secondary constructor

    println(x)
  }


}


