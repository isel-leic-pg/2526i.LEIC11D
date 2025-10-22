

fun printOper(a: Int, b: Int, op: (Int,Int)->Int) {
    println(op(a,b))
}

fun main() {
    printOper(10,2,::add)
    val fx = ::sub
    printOper(10,2,fx)

    val f = { c: Char, n: Int -> c+n }
    println(f('A',2))

    printOper(10,2, {a,b -> a*b} )
    printOper(10,2) { a,b -> a/b }

    repeat(3) { idx ->
        println("PG $idx")
    }
}
