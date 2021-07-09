package exercises

import scala.util.Try

object Initials {
  def main(args: Array[String]): Unit = {

    object NameInitials {
      def apply(str: String): String = str

      def unapply(fullName: String): Option[String] = {
        val stringArray: Array[String] = fullName.split(" ")
        if (stringArray.tail.nonEmpty) Some(stringArray.head.substring(0, 1) +
          ". " + stringArray.last.substring(0, 1) + ".") else None
      }
    }

    val input = Try(scala.io.StdIn.readLine())
    //val input = Try(throw new RuntimeException)
    if (input.isSuccess) {
      val fullName = input.get
      fullName match {
        case NameInitials(fullName) if (fullName != null && fullName.nonEmpty) => println(fullName)
        case _ => println("Oops, something is wrong")
      }
    } else println("Oops, something is wrong")
  }
}
