package lectures.week1basics

object Expressions extends App {
  val aVal = 1 + 2 * 3
  val aCondition = true
  println(if(aCondition) "True Condition" else "False Condition")
  val someVal: Unit = print("I just want to print")
  print("\n" + someVal)
  val someVal2 = print("I just want to print")
  println(someVal2)
}
