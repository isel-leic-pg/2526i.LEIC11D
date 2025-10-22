
fun add(a: Int, b: Int) = a + b

fun sub(a: Int, b: Int) = a - b

fun double(a: Int) = 2 * a

fun main() {
    println(add(5,3))
    println(sub(5,3))

    val fx: (Int,Int)->Int = ::add
    val res = fx(10,2)
    println(res)
    println("List of funs")
    val fxs: List<(Int,Int)->Int> = listOf(::add, ::sub)
    for(f in fxs)
        println(f(10,2))
}
