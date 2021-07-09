package exercises

object LinkedList extends App {
  abstract class LogList {
    def add(msg: String): LogList       //добавляет сообщение в список
    def previous: LogList  //возвращает все ранее поступившие собщения(tail), за исключением head
    def all: String         //содержимое списка в виде строки
    def isEmpty: Boolean    //проверяет, если ли списке сообщения
    def last: String       //возвращает последнее поступившее сообщение (иначе говоря - head списка)
  }
  class Log(val head: String = "", val tail: LogList) extends LogList {
    def add(msg: String): LogList = new Log(msg, this)
    def previous: LogList = tail
    def all: String = {
      def go(tail: LogList, acc: String = head): String = {
        if (tail.isEmpty) acc
        else go(tail.previous, acc + s" ${tail.last}")
      }
      go(tail, head)
    }
    def isEmpty: Boolean = {
      if (head == "") true
      else false
    }
    def last: String = head
  }
  object Empty extends LogList {
    def add(msg: String): LogList = new Log(msg, Empty)
    override def previous: LogList = throw new NoSuchElementException
    def all: String = ""
    def last: String = throw new NoSuchElementException
    def isEmpty : Boolean = true
  }
  val list = new Log("a", new Log("b", new Log("c", Empty)))
  println(list.previous.all)
  print(list.all)
}
