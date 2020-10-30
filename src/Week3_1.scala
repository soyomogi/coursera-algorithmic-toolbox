object Week3_1 extends App {
  val scanner = new java.util.Scanner(System.in)
  // 1 <= m <= 10^3
  val m = scanner.nextInt
  val ten = m / 10
  val tenRest = m % 10
  val five = tenRest / 5
  val fiveRest = tenRest % 5
  print(ten + five + fiveRest)
}