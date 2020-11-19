package lectures.part2oop // mirror the file structure

//import playground.{Cinderella, PrinceCharming}
//import playground._ // (import *) use if you really need it

import java.util.Date

import playground.{PrinceCharming, Cinderella => Princess}
//import java.sql.Date
import java.sql.{Date => sqlDate} // name aliasing

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Mohammad", "Masoumi", 2020)

  // import the package
  //  val princess = new Cinderella // before aliasing
  val princess = new Princess
  val newPrincess = new playground.Cinderella // playground.Cinderella = fully qualified name

  // packages are hierarchy
  // matching folder structure.

  // package object
  // Rarely use in practice but might be found quite handy
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val newPrince = new PrinceCharming

  val d = new Date // compiler assume first import

  /*
    How to overcome importing with the same name
   */
  // 1. use fully qualified name
  val sqlDate = new java.sql.Date(2020, 11, 11)

  // 2. aliasing
  val anotherSqlDate = new sqlDate(2020, 4, 5)

  // default imports:
  // 1, java.lang - String, Exception, Object
  // 2. scala - Int, Nothing, Function
  // 3. scala.Predef - println, ???

}
