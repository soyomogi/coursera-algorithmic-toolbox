object Test1_2 extends App {
  val scanner = new java.util.Scanner(System.in)
  // 2 <= n <= 200000
  val N = scanner.nextLine().toInt
  // 0 <= a1,...,an <= 200000
  val As = scanner.nextLine().split(" ").map(_.toLong)
  val nums = As take N

  var top2 = nums.take(2).sorted
  nums.drop(2).foreach(l =>
    if(l <= top2.head){

    } else if (top2.head < l && l < top2.last){
      top2 = Array(l, top2.last)
    } else if (top2.last <= l) {
      top2 = Array(top2.last, l)
    }
  )

  val result = top2 match {
    case Array(x, y) => x * y
  }
  print(result)
}
