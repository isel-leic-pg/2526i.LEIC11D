import pt.isel.canvas.Canvas

const val VELOCITY = 3
const val RADIUS = 50

data class Ball(
    val center: Point,
    val dx: Int,
    val color: Int,
)

fun Ball.colide(): Boolean =
    dx > 0 && center.x > MAX_X-RADIUS || dx < 0 && center.x < RADIUS

fun Ball.move(): Ball {
    val newDx = if (colide()) -dx else dx
    val newCenter = Point(center.x + newDx, center.y)
    return Ball(newCenter,newDx, color)
}

fun Canvas.draw(b: Ball) {
    drawCircle(b.center.x, b.center.y, RADIUS, b.color)
}

fun Ball.isIn(p: Point): Boolean = distance(center,p) <= RADIUS
