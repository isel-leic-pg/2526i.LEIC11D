
data class Time(
    val h:Int,
    val m:Int = 0,
    val s:Int = 0
)

fun readTime(): Time {
    val h = readInt("horas")
    val m = readInt("minutos")
    val s = readInt("segundos")
    return Time(h,m,s)
}

fun main() {
    val time: Time = readTime()

    if ( isValidTime(time) )
        println("Total em segundos = ${seconds(time)}")
    else
        println("Tempo inválido")
}

fun seconds(t: Time): Int = t.h*3600 + t.m*60 + t.s

fun isValidTime(t: Time) =
    t.h >= 0 &&
    t.m in 0..<60 &&
    t.s in 0..<60