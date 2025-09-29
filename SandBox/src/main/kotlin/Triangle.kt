fun main() {
    val a = readInt("A")
    val b = readInt("B")
    val c = readInt("C")
    val type = typeOfTriangle(a,b,c)
    println("O triangulo é $type")
}

fun readInt(name: String): Int {
    print("$name? ")
    return readln().toInt()
}

fun typeOfTriangle(a: Int, b: Int, c: Int) = when {
    a >= b+c || b >= a+c || c >= a+b -> "Impossível"
    a==b && b==c -> "Equilatero"
    a==b || b==c || a==c -> "Isósceles"
    else -> "Escaleno"
}