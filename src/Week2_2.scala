import scala.annotation.tailrec

object Week2_2 extends App {
  val scanner = new java.util.Scanner(System.in)
  val N = scanner.nextLine().toLong
  // 0 <= N <= 10^7
  // フィボナッチ数のlast digit

  if (N <= 1) {
    print(N)
  } else {
    val fiblist = makeFibList(Array(1, 0), N)
    print(fiblist.head)
  }

  @tailrec
  def makeFibList(previous: Array[Int], n: Long): Array[Int] = {
    previous match {
      case Array(a, b) if n > 1 =>
        val next = (a + b) % 10
        makeFibList(Array(next, a), n - 1)
      case _ =>
        previous
    }
  }
}
