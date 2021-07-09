package exercises

object PartialFunction extends App {
  val partial : PartialFunction[String, String] = {
    case "hello" => "Hi, I'm Bot"
    case "bye" => "Bye-bye"
    case "what's up" => "sup-sup"
  }
  val chatbot = partial.lift
  println(chatbot("hello"))
  println(chatbot("what's up"))
  scala.io.Source.stdin.getLines().map(chatbot).foreach(println)
}
