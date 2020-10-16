import scala.annotation.tailrec

object Week2_3 extends App {
  val scanner = new java.util.Scanner(System.in)
  val pair: Array[Long] = scanner.nextLine().split(" ").map(_.toLong)
  // 1 <= a,b <= 2.10^9
  // 最大公約数
  // val answer = calcGcd(pair.sorted).max
  // print(answer)
  print(calcGcd(pair.sorted).max)

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
