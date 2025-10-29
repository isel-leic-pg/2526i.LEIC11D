import kotlin.math.*

data class Point(val x: Int, val y: Int)

fun distance(a: Point, b: Point): Double {
    val c1 = abs(a.x - b.x)
    val c2 = abs(a.y - b.y)
    return sqrt( (c1*c1 + c2*c2).toDouble() )
}