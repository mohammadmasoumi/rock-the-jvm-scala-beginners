package lectures.part2oop

object Generics extends App {

  // traits also can be type parameterize

  class MyList[+A] {
    // use the type A

    //    def add(element: A): MyList[A] = ??? HARD QUESTION
    def add[B >: A](element: B): MyList[B] = ??? // change return type
    /*
      A: Cat
      B: Animal
      return: Animal
     */
  }

  class MyMap[A, B] {

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]


  // Objects can't be type parameterize
  object MyList {
    def empty[A]: MyList[A] = ??? // user generic in the method definition

  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem

  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // 1. YES - COVARIANCE
  // List[Cat] extends List[Animal] = COVARIANCE

  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog) ??? HARD QUESTION. => we return a list of animal
  // Can we add a Dog into list of Cats ???

  // 2. NO - INVARIANCE
  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. HELL NO - CONTRAVARIANCE
  // relationship is opposite
  class ContravariantList[-A]

  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]


  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]


  // bounded types

  // 1. UPPER BOUNDED TYPE
  class Cage[A <: Animal](animal: Animal) // A is subtype of Animal

  val cage = new Cage(new Dog)

  //  class Car
  //  val newCage = new Cage(new Car) // Compiler will throw error

  // 2. LOWER BOUNDED TYPE
  class LowerBoundCage[A >: Animal](animal: Animal)


}
