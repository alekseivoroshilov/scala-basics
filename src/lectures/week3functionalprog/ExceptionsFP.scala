package lectures.week3functionalprog
import scala.util.Try

object ExceptionsFP extends App {
  def unsafeMethod(): String = throw new RuntimeException("Sorry, not your day")

  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure) // Failure(java.lang.RuntimeException: Sorry, not your day)

  val anotherPotentialFailure = Try {
    // код, содержащий исключения
  }
  println(potentialFailure.isSuccess) // false





  def myMethod(): String = "My method is valid"

  val executeWithTry = Try(unsafeMethod()).orElse(Try(myMethod()))

  println(executeWithTry) // Success(My method is valid)
}
