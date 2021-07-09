package exercises

import scala.annotation.tailrec

object TailRecursion extends App{
  // начните писать свой код здесь
  def increaseNumberSeveralTimes(x:Int, y:Int, n:Int): Int = {
    @tailrec
    def go(i:Int, acc:Int = x): Int = {
      if (i < 0) 0
      else if (i < 1) acc
      else go(i - 1, acc + y)
    }
    go(n)
  }

  def repeatOutput(number:Int): String = {
    @tailrec
    def go(i:Int, acc:String = ""): String = {
      if (i < 0) ""
      else if (i < 1) acc
      else go(i - 1, number + s" $acc")
    }
    s"${go(number.toString.length)}is the result"
  }

  val number = increaseNumberSeveralTimes(14, 1, 6)
  println(s"${repeatOutput(number)}")
}
