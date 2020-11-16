package lectures.part2oop

object Inheritance extends App {

  // extends a class = inheriting non-private fields and methods
  sealed class Animal {
    val creatureType: String = "wild" // we can override values, variables, methods

    def eat: Unit = println("public eat!!!")

    def publicEat: Unit = println("public eat!")

    private def privateEat: Unit = print("private eat!") // accessible only to this class
    protected def protectedEat: Unit = println("protected eat!")

  }

  // SINGLE-CLASS INHERITANCE
  class Cat(override val creatureType: String = "domestic") extends Animal { // one way of overriding values
    override protected def protectedEat: Unit = {
      super.protectedEat
      println("Cat protectedEat method!")
    }

    override def eat: Unit = println("Cat override eat eat method!")
  }

  val cat = new Cat
  cat.eat // refers to the first overridden method definition!
  cat.publicEat

  // cat.privateEat (inaccessible)
  // cat.protectedEat (inaccessible)

  // constructor
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 10) // constructor
  }

  //  class Adult(name:String, age:Int, idCard: Int) extends Person (Invalid constructor signature!)
  class Adult(name: String, age: Int, idCard: Int) extends Person(name = name, age = age)

  // Or we can use any constructor on the Person class
  //  class Adult(name: String, age: Int, idCard: Int) extends Person(name = name)

  /*
    Overriding of values:

    1. In the class constructor -> see Cat
    2. In the body of class -> see Dog
   */

  class Dog extends Animal {
    override val creatureType: String = "K9" // another way of overriding values
    override def eat: Unit = println("Crunch Crunch!")
  }

  //
  //  class Dog(override val creatureType: String) extends Animal
  //  val newDog = new Dog(creatureType = "K9")


  val dog = new Dog
  dog.eat

  // type substitution (broad:  polymorphism)
  val unknownAnimal: Animal = new Dog // most overridden version

  // overRIDING vs overLOADING


  //  final class FinalAnimal {
  //    def eat: Unit = println("eat")
  //  }
  //  class newDog extends FinalAnimal // illegal inheritance

  /*
    Preventing override:

      1. use final keyword on members
      2. use final keyword on class (String types are finals in scala)
      3. seal the class = extend classes in THIS FILES, prevent extension in OTHER FILES.
      we usually use sealed keyword whenever we want to seal the extension f.g:
        Cat and Dog are the ony animals in the world!

   */

}
