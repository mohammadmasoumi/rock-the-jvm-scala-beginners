package lectures.part4patterns

object Options extends App {
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // Options are invented to deal with UNSAFE APIs.

  // unsafe APIs
  def unsafeMethod(): String = null

  // val result = Some(unsafeMethod()) // WRONG: Some(null) -> break the whole point
  val result = Option(unsafeMethod()) // we don't need to check for null
  println(result)

  // chained method
  def backupMethod() = "A valid result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  /*
    Design APIs to return null
   */
  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterBackupMethod() orElse betterBackupMethod()

  println(betterChainedResult)

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE, don't use it.

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // because we have map, flatMap, filter -> we will have for-comprehension
  // for-comprehension

}
