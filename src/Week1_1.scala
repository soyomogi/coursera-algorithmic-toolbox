object Week1_1 extends App {
  val scanner = new java.util.Scanner(System.in)
  val line = scanner.nextLine()
  val result = (line.split(" ").map(x => BigInt(x)) take 2).sum
  print(result)
}
