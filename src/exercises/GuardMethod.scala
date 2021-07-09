package exercises

object GuardMethod extends App {
  def guard (data: Any, maxLength: Int): String = {
    val result = data match {
      case someList@List(_, _*) if someList.length <= maxLength => s"Задан список $someList допустимой длины"
      case someList@List(_, _*) if someList.length > maxLength => "Длина списка больше максимально допустимого значения"
      case string: String if string.length <= maxLength => "Длина строки не превышает максимально допустимого значения" //TODO
      case string: String if string.length > maxLength => "Получена строка недопустимой длины" //TODO
      case _ => "Что это? Это не строка и не список"
    }
    result
  }
  println(guard(List(1, 2), 3))
  println(guard(List(1, 2), 1))
  println(guard("loh", 1))
  println(guard("loh", 4))

  def guard2(data: Any, maxLength: Int): String = data match {
    case x: List[Any] if x.length <= maxLength => "Задан список List допустимой длины"
    case _: List[Any] => "Длина списка больше максимально допустимого значения"
    case x: String if x.length <= maxLength => "Длина строки не превышает максимально допустимого значения"
    case _: String => "Получена строка недопустимой длины"
    case _ => "Что это? Это не строка и не список"
  }
}
