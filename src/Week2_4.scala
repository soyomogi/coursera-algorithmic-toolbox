import scala.annotation.tailrec

object Week2_4 extends App {
  val scanner = new java.util.Scanner(System.in)
  val pair: Array[Long] = scanner.nextLine().split(" ").map(_.toLong)
  // 1 <= a,b <= 10^7
  // 最小公倍数
  val gcd = calcGcd(pair.sorted).max
  // val answer = pair.head * pair(1) / gcd
  // print(answer)
  print(pair.head * pair(1) / gcd)

  @tailrec
  def calcGcd(pair: Array[Long]): Array[Long] = {
    pair match {
      case Array(a, _) if a == 0 =>
        pair
      case Array(a, b) =>
        val div = b / a
        val newPair = Array(b - div * a, a)
        calcGcd(newPair)
    }
  }
}
