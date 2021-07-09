package lectures.week1basics

object Functions extends App {
  def aPerson(name : String, surname : String): String ={
    s"$name $surname"
  }
  println(aPerson("Alex", "Steiner"))
  def aParameterlessFunction(): Unit = println("Function with no parameters")
  aParameterlessFunction


  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())


  def someFunc(): Int = 2 * someFunc() + 1
  def callSomeFunc(x: Int, y: => Int) = println(x)

  callSomeFunc(1, someFunc())

  def aBossFunction(): String = {
    def aHelperFunction(): String = "I'm here to help"

    aHelperFunction()
  }

  def aCondition(): Boolean = if ( 1 < 2) true else false
}
