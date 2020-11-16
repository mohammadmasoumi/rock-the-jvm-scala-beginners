package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract classes
  abstract class Animal {
    val creatureType: String
    val nonAbstractMember: String = "This is a non abstract member!"

    def eat: Unit
  }

  // Class 'Animal' is abstract; cannot be instantiated
  //  val animal: Animal = new Animal

  class Dog extends Animal {
    //    override val creatureType: String = "wild"
    val creatureType: String = "K9" // we can omit override keyword

    override def eat: Unit = println("Dog is eating!")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit // abstract
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded {

  }

  // we can use how many traits that we want
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    override val nonAbstractMember: String = "non abstract member is overridden!"

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a {${animal.creatureType}}!")

    override def eat: Unit = println("I'm a croc and I'm eating sth!")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc.eat(dog)


  /*
    Abstract vs Trait

    1. both traits and abstract classes can have both abstract and non-abstract members
    2. traits do not have constructor parameters
    3. multiple traits may be inherited by the same class (multiple inheritance)
    4. traits are behaviour (what they do), abstract classes are type of thing

   */


  /*
    Scala Hierarchy

                                                       Scala.Any

             Scala.AnyVal[Int, Unit, Boolean, Float]              Scala.AnyRef(java.lang.Object)[String, Set, List]

                                                                                Scala.Null

                                                     Scala.Nothing
   */


}
