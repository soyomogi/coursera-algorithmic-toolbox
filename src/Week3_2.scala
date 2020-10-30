object Week3_2 extends App {
  val sc = new java.util.Scanner(System.in)
  // 1 <= n <= 10^3
  // 0 <= W <= 2*10^6
  val n, W = sc.nextInt
  // 0 <= vi <= 2*10^6
  // 0 < wi <= 2*10^6
  val v_ws = List.fill(n, 2)(sc.nextInt)
  val sorted = v_ws.sortBy {
    case List(v, w) => -((v + 0.0) / w)
  }

  def kz(items: List[List[Int]],
         remain: Int,
         score: Double
        ): Double = items match {
    case _ if remain == 0 =>
      score
    case List(v, w) :: _ if w > remain =>
      score + v * remain / (w + 0.0)
    case List(v, w) :: Nil =>
      score + v
    case List(v, w) :: rest =>
      kz(rest, remain - w, score + v)
  }

  val answer = kz(sorted, W, 0)
  println(Math.round(answer * 10000) / 10000.0000)
}