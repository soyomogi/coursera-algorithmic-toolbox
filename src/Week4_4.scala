object Week4_4 extends App {
  val sc = new java.util.Scanner(System.in)
  val n = sc.nextInt // 1 - 10^5
  val As: List[Long] = List.fill(n)(sc.nextLong) // 1 - 10^9

  case class LC(list: List[Long], count: Int)

  val res = mergeSortAndCount(As)
//  println(res.list)
  println(res.count)

  def mergeSortAndCount(a: List[Long]): LC = {
    a match {
      case _ :: Nil =>
        LC(a, 0)
      case _ =>
        val mid = a.size / 2
        val (left, right) = a.splitAt(mid) // 2分割
        val newLeft = mergeSortAndCount(left)
        val newRight = mergeSortAndCount(right)
//        println(newLeft.toString + "\t" + newRight.toString)
        merge(newLeft, newRight)
    }
  }

  def merge(left: LC, right: LC): LC = {
    (left, right) match {
      case (LC(Nil, _), LC(rl, rc)) => // leftが空
        LC(rl, rc)
      case (LC(ll, lc), LC(Nil, _)) => // rightが空
        LC(ll, lc)
      case (LC(ll, lc), LC(rl, rc)) if ll.head <= rl.head =>
        val leftTail = LC(ll.tail, lc)
        val merged = merge(leftTail, right)
        LC(ll.head +: merged.list, merged.count)
      case (LC(ll, lc), LC(rl, rc)) if ll.head > rl.head =>
        val rightTail = LC(rl.tail, rc)
        val merged = merge(left, rightTail)
        LC(rl.head +: merged.list, merged.count + 1)
    }
  }
}