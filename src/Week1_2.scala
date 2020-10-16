object Week1_2 extends App {
  val scanner = new java.util.Scanner(System.in)
  // 2 <= n <= 200000
  val N = scanner.nextLine().toInt
  // 0 <= a1,...,an <= 200000
  val As = scanner.nextLine().split(" ").map(_.toLong)
  val nums = As take N

  var top2 = nums.take(2).sorted
  nums.drop(2).foreach { l =>
    val t1 = top2.head
    val t2 = top2.last
    if (l <= t1) {
    } else if (t1 < l && l < t2) {
      top2 = Array(l, t2)
    } else if (t2 <= l) {
      top2 = Array(t2, l)
    }
  }

  val result = top2 match {
    case Array(x, y) => x * y
  }
  print(result)
}
