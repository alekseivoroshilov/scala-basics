package lectures.week3functionalprog

object Collections extends App{
  val fruits = List("apple", "banana")

  val mapResult = fruits.map(_.toUpperCase)
  val flatResult = fruits.flatMap(_.toUpperCase)

  println(mapResult) // List(APPLE, BANANA)
  println(flatResult) // List(A, P, P, L, E, B, A, N, A, N, A)
  val s = "Hello"
  val newStr: String = s.flatMap(c => (c + "."))
  println(newStr) // H.e.l.l.o.
  println(s.map(c => (c + "."))) // ArraySeq(H., e., l., l., o.)

  val list1 = List(1, 2)
  val list2 = List("a", "b")
  val list3 = List(3, 4)

  val combinations = list1.flatMap(n => list2.map(c => list3.map(t => n + c + t)))
  val forCombination = for {
    n <- list1
    c <- list2
    t <- list3
  } yield n + c + t
  println(combinations)
  println(forCombination)

  val sampleTuple = new Tuple2(2, "Hello, World")
  println(sampleTuple.copy(_2 = "Scala").swap._1 + 2)

}
