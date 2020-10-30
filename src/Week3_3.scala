object Week3_3 extends App {
  val sc = new java.util.Scanner(System.in)
  // 1 <= d <= 10^5 dist
  // 1 <= m <= 400 full tank
  // 1 <= n <= 300 stops count
  val d, m, n = sc.nextInt
  // 0 < stop1 < stop2 < ... < stopn < d
  val stops = List.fill(n)(sc.nextInt) :+ d
  // 給油回数 無理なら-1

  def fuel(sts: List[Int],
           st_k_0: Int,
           remain: Int,
           count: Int
          ): Int = {
    val target = remain + st_k_0
    sts match {
      case st_k_1 :: st_k_2 :: rest if target >= st_k_2 =>
        fuel(st_k_2 :: rest, st_k_1, target - st_k_1, count)
      case st_k_1 :: st_k_2 :: rest if st_k_1 <= target && target < st_k_2 =>
        fuel(st_k_2 :: rest, st_k_1, m, count + 1)
      case st_k_1 :: _ if target < st_k_1 =>
        -1
      case st_k_1 :: Nil =>
        count
    }
  }
  val answer = fuel(stops, 0, m, 0)

  print(answer)
}