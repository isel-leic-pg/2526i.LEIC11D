

fun main() {
    val h = readInt("horas")
    val m = readInt("minutos")
    val s = readInt("segundos")

    if ( isValidTime(h,m,s) ) {
        val total = seconds(h, m, s)
        println("Total em segundos = $total")
    } else
        println("Tempo inválido")
}

fun seconds(hs: Int, ms: Int, ss: Int): Int =
    hs*3600 + ms*60 + ss

fun isValidTime(hs: Int, ms: Int, ss: Int) =
    hs >= 0 &&
    ms in 0..<60 &&
    ss in 0..<60