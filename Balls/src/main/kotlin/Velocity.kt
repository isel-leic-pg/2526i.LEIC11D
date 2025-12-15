
data class Velocity(
    val dx: Int,
    val dy: Int
)

operator fun Point.plus(v: Velocity) =
    Point(x + v.dx, y + v.dy)