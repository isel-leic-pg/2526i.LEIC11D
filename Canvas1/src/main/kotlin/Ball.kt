

data class Ball(val center: Point, val dx: Int)

fun Ball.colide(): Boolean =
    dx > 0 && center.x > MAX_X-RADIUS || dx < 0 && center.x < RADIUS

fun Ball.move(): Ball {
    val newDx = if (colide()) -dx else dx
    val newCenter = Point(center.x + newDx, center.y)
    return Ball(newCenter,newDx)
}