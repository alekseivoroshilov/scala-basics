package lectures.week3functionalprog
import scala.reflect.runtime.universe._

object Patterns extends App{
  val someVal = 3

  val description = someVal match {
    case 1 => "action 1"
    case 2 => "action 2"
    case 3 => "action three"
    case _ => "default action"
  }

  println(description) // action three

  val x: Any = "Scala"
  val constants = x match {
    case 1 => "число"
    case "Scala" => "строка"
    case true => "булевое значение"
  }

  val aTuple = (5,2)
  val matchATuple = aTuple match {
    case (1, 1) => "полное совпадение"
    case (something, 2) => s"я нашел $something"
  }

  println(matchATuple) // я нашел 5

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) => s"тут есть число $v"
  }

  println(matchNestedTuple) // тут есть число 3

  val aStandardList = List(5, 4)
  val listMatching = aStandardList match {
    case List(1, _, _, _) => "список из 4 элементов, где первый элемент равен 1"
    case List(2, _*) => "список произвольной длины, где первый элемент равен 2"
    case List(3, 2, 1) :+ 0 => "список List(3, 2, 1, 0)"
    case 5 :: List(_) => "список, где первым идет число 5 и еще один элемент"
  }

  val unknown: Any = List(1, 2  )
  val typeMatch = unknown match {
    case list: List[Int] => "list of INTs"
    case _ => "default"
  }

  println(typeMatch) // list of INTs

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 30)
  val greeting = bob match {
    case Person(n, a) if a < 18 => s"I'm $n and I'm under 18"
    case Person(n, a) => s"I'm $n and I am $a years old"
    case _ => "I have no name"
  }

  println(greeting) // I'm Bob and I am 30 years old

  val nameBindingMatch = List(6, 2) match {
    case nonEmptyList@List(1, _, _, _) => s"нашли $nonEmptyList"
    case someList@List(6, _*) => s"нашли список $someList"
  }

  println(nameBindingMatch) // нашли список List(6, 2)

  def paramInfo[T: TypeTag](x: T): Unit = {
    val targs = typeOf[T] match { case TypeRef(_, _, args) => args }
    println(s"type of $x has type arguments $targs")
  }
  paramInfo(42)
  paramInfo(List(1, 2))

}
