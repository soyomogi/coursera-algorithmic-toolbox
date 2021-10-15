object Week5_1 extends App {
  val sc = new java.util.Scanner(System.in)
  val money = sc.nextInt // 10^3

  val div = money / 4
  val mod = money % 4

  val res = (div, mod) match {
    case (0, 1) => 1
    case (0, 2) => 2
    case (0, 3) => 1
    case (_, 0) => div
    case (_, _) => div + 1
  }
  println(res)
}