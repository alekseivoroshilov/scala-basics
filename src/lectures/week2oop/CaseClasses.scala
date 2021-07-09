package lectures.week2oop

object CaseClasses extends App {
  case class Person(name: String, occupation: String)

  val bob = Person("Bob", "Developer")

  val anotherBob = bob.copy()
  println(bob) // Person(Bob,Developer)
  println(anotherBob) // Person(Bob,Developer)

  val bobsTwin = bob.copy(name = "John")
  println(bobsTwin) // Person(John,Developer)

  val alice = Person("Alice", "Engineer") // метод apply в действии

  case class Course(title: String, instructor: String)

  object Course {
    def apply(instructor: String): Course = Course("AdvancedScala", instructor)
  }

  val scalaCourse = Course("Scala", "Bob")
  val course = new Course("Scala", "Bob")
  println(course)

}
