package exercises

object CompareVersions extends App {
  def compare(v1: String, v2: String): Int = {
    val version1 = v1.split("\\.").map(n => n.toInt).toList
    val version2 = v2.split("\\.").map(n => n.toInt).toList
    val maxIndex = Set(version1.size, version2.size).min
    def go(n: Int): Int = {
      if (n >= maxIndex) 0
      else if (version1(n) < version2(n)) -1
      else if (version1(n) > version2(n)) 1
      else go(n + 1)
    }
    go(0)
  }
  println(compare("0.9", "1.0"))  // -1
  println(compare("1.01", "1.1")) // 0
  println(compare("1.1", "1.0"))  // 1
}
