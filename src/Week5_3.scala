import scala.collection.mutable.{Map => MMap}
import scala.collection.mutable.{Seq => MSeq}

object Week5_3 extends App {
  val sc = new java.util.Scanner(System.in)
  val before = " " + sc.nextLine
  val after = " " + sc.nextLine
  val bLength = before.length
  val aLength = after.length
  val table = (for (b <- before; a <- after) yield (b, a)).grouped(aLength).toList
  val distMap: MMap[(Int, Int), Int] = MMap[(Int, Int), Int]()
  val dist = editDist(bLength - 1, aLength - 1)
  println(dist)

  def editDist(a: Int, b: Int): Int = {
    (a, b) match {
      case (0, _) =>
        distMap += ((a, b) -> b)
        b
      case (_, 0) =>
        distMap += ((a, b) -> a)
        a
      case (_, _) =>
        val pair = table(a)(b)
        val isMatch = pair == pair.swap
        val dist = Seq(
          distMap.getOrElse((a - 1, b), editDist(a - 1, b)) + 1,
          distMap.getOrElse((a, b - 1), editDist(a, b - 1)) + 1,
          distMap.getOrElse((a - 1, b - 1), editDist(a - 1, b - 1)) + (if (isMatch) 0 else 1),
        ).min
        distMap += ((a, b) -> dist)
        dist
    }
  }
}