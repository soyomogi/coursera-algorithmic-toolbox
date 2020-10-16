import scala.annotation.tailrec

object Week2_5 extends App {
  val scanner = new java.util.Scanner(System.in)
  val Seq(n, m): Seq[Long] = scanner.nextLine().split(" ").map(_.toLong)
  // 1 <= n <= 10^14, 2 <= m <= 10^3 .
  // フィボナッチ数のmod

  // 逆順で持っておく
  val fibModList = makeFibModList(Seq(1, 0), m)
  val modSize = fibModList.size
  val modIndex = (n % modSize).toInt
  // val answer = fibModList(modSize - modIndex - 1)
  // print(answer)
  print(fibModList(modSize - modIndex - 1))

  @tailrec
  def makeFibModList(previous: Seq[Long], mod: Long): Seq[Long] = {
    previous match {
      case 1 :: 0 :: rest if rest.nonEmpty =>
        rest
      case a :: b :: rest =>
        val next = (a + b) % mod
        makeFibModList(next +: a +: b +: rest, mod)
    }
  }


}
