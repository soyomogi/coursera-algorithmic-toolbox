
object Week5_2 extends App {
  val sc = new java.util.Scanner(System.in)
  val input = sc.nextInt // 10^6
  val steps_init: Seq[Int] = Seq(input)
  val (num1, res_list) = greedy(input, steps_init)

  println(res_list.size - 1)
  println(res_list.mkString(" "))

  def greedy(num: Int, step: Seq[Int]): (Int, Seq[Int]) = {
    val div = num / 6
    val mod = num % 6
    mod match {
      // mod6に関係ないルール
      case 0 if div == 0 =>
        (1, step)
      case 1 if div == 0 =>
        (1, step)
      case 2 if div == 0 =>
        (1, 1 +: step)
      // mod6ルール
      case 0 | 3 => // 6n
        val n = num / 3
        greedy(n, Seq(n) ++ step)
      case 1 | 5 => // 6n+1
        val n = num - 1
        greedy(n, Seq(n) ++ step)
      case 2 | 4 => // 6n+2 = 2(3n+1)
        val next1 = num / 2
        val next2 = num - 1
        lazy val greedyResult1 = greedy(next1, Seq(next1) ++ step)
        lazy val greedyResult2 = greedy(next2, Seq(next2) ++ step)
        if (greedyResult1._2.size < greedyResult2._2.size) {
          greedyResult1
        } else {
          greedyResult2
        }
    }
  }
}