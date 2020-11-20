package lectures.part3fp

object AnonymousFunctions extends App {

  val doubler = new Function[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }

  // anonymous function (LAMBDA)

  val doublerWithOutType = (x: Int) => x * 2
  val newDoubler: Int => Int = (x: Int) => x * 2
  val anotherDoubler: Int => Int = x => x * 2 // x will be Int (now compiler know)

  // multiple parameters
  val adder = (a: Int, b: Int) => a + b
  val anotherAdder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no parameter
  val justDoSth: () => Int = () => 3

  println(justDoSth)
  println(justDoSth()) // in lambdas we must call them

  // curly braces with lambdas (practical)
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = x => x + 1
  val syntacticSugarNiceIncrementer: Int => Int = _ + 1
  val syntacticSugarAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b | types should be declared

  println(niceIncrementer(4))
  println(syntacticSugarNiceIncrementer(4))

  /*
    Assignments:
      1. MyList: replace all FunctionX calls with lambdas.
      2. rewrite "special" adder as anonymous function.
   */

  val superAdder: Int => Int => Int =
    x => y => x + y

  println(superAdder(1)(2))

}
