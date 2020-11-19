package lectures.part2oop

object AnonymousClasses extends App {


  abstract class Animal {
    def eat: Unit
  }


  // Anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahahaha")
  }
  /*
    equivalent with

    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("hahahaha")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)


  class Person(name: String) {
    def sayHi: Unit = println(s"Hi my name is $name, how can I help you?")
  }

  // anonymous classes work for both abstract and non-abstract classes
  val jim = new Person("Jim") { // always pass parameters, super classes you are extending
    override def sayHi: Unit = println(s"Hi my name is Jim, how can I be of service?")
  }


}
