package lectures.part3fp

object TuplesAndMaps extends App {


  /*
    tuples - finite ordered "List"

   */

  val aTuple: (Int, String) = new Tuple2[Int, String](2, "Hello, Scala")
  println(aTuple)

  // Syntactic sugar
  val aSyntacticSugarTuple: (Int, String) = (2, "Hello, Scala")
  println(aSyntacticSugarTuple)

  // more syntactic sugar
  val moreSyntacticSugarATuple = 2 -> "Hello, Scala"
  println(moreSyntacticSugarATuple)

  // functions on Tuples
  println(aTuple._1) // indexed access
  println(aTuple.copy(_2 = " Updated Hello Scala"))
  println(aTuple.swap) // ("Hello, Scala", 2)

  /*
    Maps key -> value
   */
  val aMap: Map[String, Int] = Map() // an empty map
  val aPhonebook: Map[String, Int] = Map(("Mohammad", 1234), ("Daniel", 456)).withDefaultValue(-1)
  val anotherPhonebook: Map[String, Int] = Map("Mohammad" -> 1234, "Daniel" -> 456)

  println(aMap)
  println(aPhonebook)
  println(anotherPhonebook)

  // map ops
  println(aPhonebook.contains("Mohammad"))
  println(aPhonebook("Mohammad"))

  // println(aPhonebook("Mary")) // throw NoSuchElementException - Not at all, I think you miss the point
  // solution? define a default value
  println(aPhonebook("Mary")) // default value or throwing exception

  // add a pairing
  val newPairing = "Mary" -> 235
  val newPhonebook = aPhonebook + newPairing
  println(newPhonebook)

  // functions on Map - map, flatMap, filter
  println(newPhonebook.map(pair => pair._1.toLowerCase -> pair._2)) // pair

  // conversions
  println(newPhonebook.toList)
  println(List(("Daniel", 221)).toMap) // vise versa

  val names = List("Mohammad", "Daniel", "Angela", "Mary", "Jim", "Bob")
  println(names.groupBy(name => name.charAt((0))))

  /*
    Exercise
      1. what would happen If I had two original entries "Jim" -> 555 and "JIM" -> 997
        answer: you will lose some data

      2. Overly simplified social network based on maps
        Person = string
          - add a person to the network
          - remove
          - friend (mutual)
          - unfriend
          - number of friends of a person
          - person with most friend
          - how many people have NO FRIEND
          - if there is a social connection between two people (direct or indirect)
   */

  val aNewPhonebook: Map[String, Int] = Map(
    "MOHAMMAD" -> 1002,
    "Mohammad" -> 1234,
    "Daniel" -> 456
  ).withDefaultValue(-1)
  // keep the last one
  println(aNewPhonebook.map(pair => pair._1.toLowerCase -> pair._2)) // pair

  // Network
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendA = network(a)
    val friendB = network(b)

    network + (a -> (friendA + b)) + (b -> (friendB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendA = network(a)
    val friendB = network(b)

    network + (a -> (friendA - b)) + (b -> (friendB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAuxiliary(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAuxiliary(friends.tail, unfriend(networkAcc, person, friends.head))
    }

    val unfriended = removeAuxiliary(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")

  println(network)
  println(friend(network, "Bob", "Mary"))

}
