
data class Velocity(
    val dx: Int,
    val dy: Int
)

operator fun Point.plus(v: Velocity) =
    Point(x + v.dx, y + v.dy)


fun main() {
    val p = Point(5,5)
    val v = Velocity(3, -2)
    println( p + v )
}