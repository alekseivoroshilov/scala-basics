package playground
import scala.collection
object ScalaPlayground {
  def main(args: Array[String]): Unit =
  {
    val list1 = List(1, 2)
    val list2 = List("a", "b")
    val list3 = List(3, 4)

    val combinations = list1.flatMap(n => list2.map(c => c + n))
    val forCombination = for {
      n <- list1
      c <- list2
      t <- list3
    } yield n + c + t
  }
  //println("Hello, Scala!")
}
