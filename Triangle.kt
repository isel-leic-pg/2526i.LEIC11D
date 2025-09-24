fun main() {
/*
    print("A? ")
	val a = readln().toInt()
    print("B? ")
	val b = readln().toInt()
    print("C? ")
	val c = readln().toInt()
*/
	print("A? B? C? ")
	val (a,b,c) = readln().split(' ').map{ it.toInt() }
	val tri = when {
	   a >= b+c || b >= a+c || c >= a+b -> "Impossível"
	   a==b && b==c -> "Equilatero"
	   a==b || b==c || a==c -> "Isósceles"
	   else -> "Escaleno"
	}
	println("O triangulo é $tri")
}