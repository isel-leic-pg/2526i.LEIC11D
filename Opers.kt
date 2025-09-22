fun main() {
   print("A? ")
   val a: Int = readln().toInt()
   print("B? ")
   val b = readln().toInt() 
   println("$a + $b = ${a+b}")
   println("$a - $b = ${a-b}")
   println("$a x $b = ${a*b}")
   println("$a / $b = ${a/b}")
   println("$a mod $b = ${a%b}")
}