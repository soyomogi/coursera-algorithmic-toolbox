import scala.annotation.tailrec
import scala.collection.mutable

object Week4_1 extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt // 1 - 3 * 10^4
  val As: Array[Long] = Array.fill(n)(sc.nextLong) // 1 - 10^9
  val k = sc.nextInt // 1 - 10^5
  val Bs: Array[Long] = Array.fill(k)(sc.nextLong) // 1 - 10^9

  var ansMap: mutable.HashMap[Long, Int] = mutable.HashMap.empty[Long, Int] // 解答を保持するためのMap
  Bs.foreach { b =>
    if (ansMap.contains(b)) {
      print(ansMap(b) + " ")
    } else {
      val (ans, isSuccess) = binarySearch(0, n - 1, b)
      if (isSuccess) {
        ansMap(b) = ans
        print(ans + " ")
      } else {
        ansMap(b) = -1
        print("-1 ")
      }
    }
  }

  // リスト内に存在しない場合はfalseを返す
  @tailrec
  def binarySearch(left: Int, right: Int, target: Long): (Int, Boolean) = {
    val length = right - left + 1
    length / 2 match {
      case 0 if As(left) != target =>
        (0, false)
      case mid if As(left + mid) > target =>
        binarySearch(left, left + mid - 1, target)
      case mid if As(left + mid) < target =>
        binarySearch(left + mid, right, target)
      case mid if As(left + mid) == target =>
        (left + mid, true)
    }
  }
}