package exercises

object WordOrderReversed extends App {
  val input = "I     Like Scala"
  val words : List[String] = input.split(" +").toList

  def reverseWordOrder(words : List[String]): String = {
    val n = words.length - 1
    var res = ""
    def go(i: Int): String = {
      if(i < 0) throw new IllegalArgumentException
      if(i == 0) {res += words.apply(i); res}
      else {
        res += s"${words.apply(i)} "
        go(i - 1)
      }
    }
    go(n)
    res
  }
  println(reverseWordOrder(words))
}
