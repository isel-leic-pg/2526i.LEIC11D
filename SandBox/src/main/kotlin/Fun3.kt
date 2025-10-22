

fun mul2(a: Int) = a*2

fun main() {
    val l = listOf(1,3,5,7,11)
    println(l.map(::mul2))
    println(l.map{ i -> 'A'+i })
    println(l.map { it/2.0F })

    println(l.mapIndexed { idx, e -> if (idx==0) 0 else e/idx })
}