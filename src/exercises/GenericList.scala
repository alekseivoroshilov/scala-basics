package exercises

object GenericList extends App {
  abstract class LogList[+A] {
    def add[B >: A](msg: B): LogList[B]       //добавляет сообщение в список
    def previous: LogList[A]  //возвращает все ранее поступившие собщения(tail), за исключением head
    def all: String         //содержимое списка в виде строки
    def isEmpty: Boolean    //проверяет, если ли списке сообщения
    def last: A       //возвращает последнее поступившее сообщение (иначе говоря - head списка)
  }
  class Log[+A](head: A, tail: LogList[A]) extends LogList[A]{
   def add[B >: A](msg: B): LogList[B] = new Log(msg, this)
    def previous: LogList[A] = tail
    def all: String = head + " " + tail.all
    def isEmpty: Boolean = {
      if (head == "") true
      else false
    }
    def last: A = head
  }
  object Empty extends LogList[Nothing] {
    override def add[B >: Nothing](msg: B): LogList[B] = new Log(msg, Empty)
    override def previous: LogList[Nothing] = throw new NoSuchElementException
    def all: String = ""
    def last: Nothing  = throw new NoSuchElementException
    def isEmpty : Boolean = true
  }
  val list = new Log("a", new Log("b", new Log("c", Empty)))
  println(list.previous.all)
  print(list.all)
}
