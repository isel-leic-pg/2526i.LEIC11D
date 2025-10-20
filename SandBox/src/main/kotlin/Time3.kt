

fun main() {
    val time: Time = readTime()

    if ( time.isValid() )
        println("Total em segundos = ${time.toSeconds()}")
    else
        println("Tempo inválido")

    val tm = Time(0,0,0)
    println(tm.isValid())  // -> true
    println(tm.toSeconds()) // -> 0

    println(Time(2).toSeconds()) // -> 2*3600

    println(time.toString())
}

fun Time.toSeconds() = h*3600 + m*60 + s

fun Time.isValid() =
    h >= 0 &&
    m in 0..<60 &&
    s in 0..<60
