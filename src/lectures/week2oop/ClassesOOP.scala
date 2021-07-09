package lectures.week2oop

object ClassesOOP extends App {
  class Employee(val name: String, var salary: Double) {
    def this() = this("John", 0.0)
  }

  val employee = new Employee()
  println(s"${employee.name}'s salary is ${employee.salary}")

  class Instructor(val id : Int, name : String, surname : String) {
    def fullName(): String = name.take(1).toUpperCase + name.substring(1, name.length) + " " +
      surname.take(1).toUpperCase + surname.substring(1, surname.length)
  }
  val inst1 = new Instructor(10,"jonny", "GUITAR")
  println(inst1.fullName())
  class Course(courseID: Int, title: String, val releaseYear: String, instructor: Instructor) {
    def getID(): String = courseID.toString + instructor.id
    def isTaughtBy(instructor: Instructor): Boolean = this.instructor == instructor
    def copyCourse(releaseYear: String): Course = new Course(courseID, title, releaseYear, instructor)
  }
  val course1 = new Course(1, "scalacourse", "2021", inst1)
  val inst2 = new Instructor(14,"mr", "newvegas")
  println(course1.getID())
  println(course1.isTaughtBy(inst1).toString + course1.isTaughtBy(inst2))
  val course2 = course1.copyCourse("2020")
  println(course2.releaseYear)
}
