package lectures.week2oop

object SyntacticSugar extends App {
  class Person(val name: String, occupation: String) {
    def worksAs(jobName: String): Boolean = jobName == occupation
    def speaksEnglish: Boolean = true
    def &(person: Person): String = s"${this.name} and ${person.name} are colleagues"
    def unary_! : String = s"$name is not real"

    def apply(): String = s"$name works as a $occupation"
  }


  val bob = new Person("Bob", "Developer")
}
