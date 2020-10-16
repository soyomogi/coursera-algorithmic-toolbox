import scala.annotation.tailrec

object Week2_1 extends App {
  val scanner = new java.util.Scanner(System.in)
  val N = scanner.nextLine().toInt
  // 0 <= N <= 45
  // フィボナッチ数
  if (N <= 1) {
    print(N)
  } else {
    val fiblist = makeFibList(Array(1, 0), N)
    print(fiblist.head)
  }

  @tailrec
  def makeFibList(previous: Array[Int], n: Int): Array[Int] = {
    previous match {
      case Array(a, b) if n > 1 =>
        val next = a + b
        makeFibList(Array(next, a), n - 1)
      case _ =>
        previous
    }
  }
}
