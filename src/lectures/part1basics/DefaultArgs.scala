package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact10 = trFact(10, 1)
  println(fact10)

  // use default args
  println(trFact(10))
  println(trFact(10, 2))


  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture!")

  // Confuse compiler
  // savePicture(800, 800)
  // we can't omit leading arguments

  /*
    1. pass in every leading arguments
    2. name the arguments
   */
  savePicture("bmp")
  savePicture("bmp", 800)
  savePicture(format = "bmp", height = 800, width = 800)
  savePicture(height = 800)


}
