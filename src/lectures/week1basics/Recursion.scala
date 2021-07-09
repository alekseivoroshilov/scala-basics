package lectures.week1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  println(factorial(3))

  //лучше хвостовая рекурсия
  def factorialWithTailRecursion(n: Int): Int = {
    def loop(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else loop(x-1, x*accumulator)
    }

    loop(n, 1)
  }
  factorialWithTailRecursion(3)

  def repeatWord(word: String, n: Int): String = {
    @tailrec
    def loop(i: Int, acc: String = word): String = {
      if (i <= 1) acc
      else loop(i - 1, s"$word $acc")
    }

    loop(n)
  }
  println(repeatWord("code!", 4))

  def calculateRowOf(n : Int): Int = {
    def loop (i : Int, acc : Int = 0): Int = {
      if (i < 0) throw new ArithmeticException
      else if (i < 1) acc
      else loop(i - 1, i + acc)
    }
    loop (n)
  }
  val param = 4
  println(s"Row of $param is ${calculateRowOf(param)}")
}
