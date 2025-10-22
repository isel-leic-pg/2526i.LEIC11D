

fun fxOper(op: Char): (Int,Int)->Int = when(op) {
    '+' -> ::add
    '-' -> ::sub
    '*','x' -> { a,b -> a+b }
    else -> { a,_ -> a }
}

fun main() {
    val f1 = fxOper('+')
    val f2 = fxOper('-')
    println(f1(10,2))
    println(f2(10,2))

    val opers = listOf('+','-','x','/')
    for (op in opers)
        println( fxOper(op)(10,2) )
}