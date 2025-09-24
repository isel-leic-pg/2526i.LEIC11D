fun main() {
  val value: Int = readln().toInt(16)
  val word: String = if (value >= 0) "positivo" else "negativo"
  println("$value é $word")
}