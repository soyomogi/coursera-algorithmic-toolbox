object Week4_3 extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt // 1 - 10^5
  val As: Vector[Long] = Vector.fill(n)(sc.nextLong) // 1 - 10^9
  val rand = new scala.util.Random
  val res = randomizedQuickSort(As)
  println(res.mkString(" "))

  def randomizedQuickSort(a: Vector[Long]): Vector[Long] = {
    if (a.size < 2) return a
    val pIndex = rand.nextInt(a.size - 1) + 1 // ランダムに決定
    val (newLeft, newMid, newRight) = partition3(a, pIndex)
    if (a == newMid) return a
    randomizedQuickSort(newLeft) ++ newMid ++ randomizedQuickSort(newRight)
  }

  def partition3(a: Vector[Long], pIndex: Int): (Vector[Long], Vector[Long], Vector[Long]) = {
    a.partition(x => x < a(pIndex)) match {
      case (left, rest) => {
        val (mid, right) = rest.partition(x => x == a(pIndex))
        (left, mid, right)
      }
    }
  }
}