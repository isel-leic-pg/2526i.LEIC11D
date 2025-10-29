import pt.isel.canvas.Canvas

const val VELOCITY = 3
val RADIUS = 10..50

data class Ball(
    val center: Point,
    val vel: Velocity,
    val color: Int,
    val radius: Int,
)

private fun Ball.coliLeft(limit: Int = 0) =
    vel.dx < 0 && center.x < limit + radius

private fun Ball.colideRight(limit: Int = MAX_X) =
    vel.dx > 0 && center.x > limit - radius

private fun Ball.colideUp(limit: Int = 0) =
    vel.dy < 0 && center.y < limit + radius

private fun Ball.colideDown(limit: Int = MAX_Y) =
    vel.dy > 0 && center.y > limit - radius

fun Ball.move(): Ball {
    val newVel = Velocity(
        dx = if (coliLeft() || colideRight()) -vel.dx else vel.dx,
        dy = if (colideUp() || colideDown()) -vel.dy else vel.dy
    )
    return copy(
        center = center + newVel,
        vel = newVel
    )
}

fun Canvas.draw(b: Ball) {
    drawCircle(b.center.x, b.center.y, b.radius, b.color)
}

fun Ball.isIn(p: Point): Boolean = distance(center,p) <= radius

fun randomVelocity() = Velocity(
    dx = (-VELOCITY..VELOCITY).random(),
    dy = (-VELOCITY..VELOCITY).random()
)