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

  /*
  Assignments

  Novel and a writer

  Writer: first name, surname, year
      method full name

  Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy(a new year of release) = new instance of Novel
   */

  class Writer(firstName: String, surname: String, val year: Int) {
    def fullName(): String = s"$firstName $surname"

    override def toString: String = s"${fullName()}"
  }

  class Novel(name: String, year: Int, author: Writer) {

    def authorAge: Int =
      year - author.year

    def isWrittenBy(author: Writer): Boolean =
      this.author == author

    def copy(newYear: Int): Novel =
      new Novel(name, newYear, author)

    override def toString: String =
      s"$name is written by ${author.fullName()} in $year."
  }


  val author: Writer = new Writer("Mohammad", "Masoumi", 2000)
  val theSameAuthor: Writer = new Writer("Mohammad", "Masoumi", 2000)
  val anotherAuthor: Writer = new Writer("New Writer", "Surname", 1990)
  val aNovel: Novel = new Novel("MyNewNovel", 2010, author)

  println(author.fullName())
  println(aNovel.authorAge)
  println(aNovel.isWrittenBy(author))
  println(aNovel.isWrittenBy(theSameAuthor)) // Equality
  println(aNovel.isWrittenBy(anotherAuthor))
  println(aNovel.copy(2020))

  /*
    Counter class:
      - receives an int value
      - method current count
      - method to increment/decrement => new Counter
      - overload inc/dec to receive an amount
   */

  class Counter(val count: Int = 0) {
    def inc: Counter = {
      println("Incrementing")
      new Counter(count + 1)
    } // immutability

    def dec: Counter = {
      println("Decrementing")
      new Counter(count - 1)
    }

    def inc(count: Int): Counter =
      if (count <= 0) this
      else inc.inc(count - 1)

    def dec(count: Int): Counter =
      if (count <= 0) this
      else dec.dec(count - 1)

    def print: String = toString

    override def toString: String = f"Count is: $count"
  }

  val counter: Counter = new Counter(1)
  println(counter.count)
  println(counter.inc)
  println(counter.count)
  println(counter.dec)
  println(counter.count)
  println(counter.inc(10))
  println(counter.count)
  println(counter.dec(10))
  println(counter
    .inc(20)
    .inc
    .dec(10)
    .dec
    .count
  )
  println(counter.inc.print)

}


