package lectures.week1basics

object StringOperations extends App {
  val aString = "Hello, partner!"
  println(aString.length)
  println(aString.charAt(2))
  println(aString.substring(0, 4))
  println(aString.split("(, )|!").toList)
  println(aString.startsWith("ell", 1))
  println(aString.replace("!", " :)"))
  println(aString.toLowerCase())
  println(aString.toUpperCase())
  println("123".reverse)
  println("123".take(2))
  println('1' +: "42" :+ '3')
  println("a" ++ "bc" :++ "d")
  println("bc".+:('a'))
  println(1 +: List(2, 3)) // List(1, 2, 3)
  println(List(1, 2) ++ List(3, 4)) // List(1, 2, 3, 4)
  println(List(1, 2) +: List(3, 4)) //List(List(1, 2), 3, 4)
  val name = "John"
  println(s"Hello, $name")
  println(raw"I want \n without new string")
}
