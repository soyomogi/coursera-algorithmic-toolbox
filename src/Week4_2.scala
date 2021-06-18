object Week4_2 extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt // 1 - 10^5
  val As: Vector[Long] = Vector.fill(n)(sc.nextLong) // 0 - 10^9

  val res = getMajorityNum(0, n)
  if (res > 0) {
    println(1)
  } else {
    println(0)
  }

  // 多数決が存在すれば1
  // 存在しなければ0
  def getMajorityNum(left: Int, right: Int): Long = right - left match {
    case 1 =>
      -1L
    case 2 =>
      As(left)
    case nn =>
      val mid = left + (right - left) / 2
      val leftMajo = getMajorityNum(left, mid)
      val rightMajo = getMajorityNum(mid, right)
      val range = As.slice(left, right)
      val leftCount = range.count(_ == leftMajo)
      val rightCount = range.count(_ == rightMajo)
      if (leftCount > nn / 2) {
        leftMajo
      } else if (rightCount > nn / 2) {
        rightMajo
      } else {
        -1L
      }
  }
}