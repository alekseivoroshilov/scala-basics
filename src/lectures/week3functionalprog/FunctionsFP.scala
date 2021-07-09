package lectures.week3functionalprog

import scala.annotation.tailrec

object FunctionsFP extends App {
  val product = new Function2[Int, Int, Int] {
    override def apply(x: Int, y: Int): Int = x * y
  }

  println(product(3, 4) ) // выводит 12
  val res = (x: Int) => x * 2
  val res2: Int => Int = x => x * 2
  val res3: (Int) => Int = _ * 2
  val res4: (Int, Int) => Int = _ * _
  val res5 = { (x: Int) =>
    x * 2
  }
  @tailrec
  def nTimes(f: Int => Int, x: Int,  n: Int): Int = { //High Order Functions
    if (n <= 0) x
    else nTimes(f, f(x), n - 1)
  }
  val increment = (x: Int) => x + 1
  println(nTimes(increment, 0, 3)) // выведет 3

  def add(x: Int) = (y: Int) => x + y //Currying Functions

  println(add(1)(2)) // 3

  def curryingNTimes(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x // лямбда-функция, что просто берет и возвращает значение
    else (x: Int) => curryingNTimes(f, n-1)(f(x))
  }

  println(curryingNTimes(increment, 3)(0))
  //def someFunc: Int => ((Int) => Int) = (x: Int) => (y: Int) => x + y
  def someFunc: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val resss = someFunc(1)(2)
  print(resss)

  val aPartialFunction: PartialFunction[String, String] = {
    case "mon" => "Work!"
    case "fri" => "Party Time"
    case "sun" => "Relax a little"
  }

  println(aPartialFunction("sun")) // Relax a little
  println(aPartialFunction("sat")) // MatchError
  println(aPartialFunction.isDefinedAt("tue")) // false

  val pfChain: PartialFunction[String, String] = aPartialFunction.orElse[String,String] {
    case "sat" => "It's just Saturday"
  }
  println(aPartialFunction("mon")) // Work!
  println(aPartialFunction("sat")) // It's just Saturday



  val lifted = aPartialFunction.lift // теперь на выходе имеем тип Option[String]

  println(lifted("fri")) // Some(Party Time)
  println(lifted("thu")) // None
}
