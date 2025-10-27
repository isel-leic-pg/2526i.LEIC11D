import pt.isel.canvas.*

const val MAX_X = 600
const val MAX_Y = 400
const val VELOCITY = 20
const val RADIUS = 50
const val FRAME_RATE = 10 // in miliseconds

fun main() {
    onStart {
        val arena = Canvas(MAX_X, MAX_Y, CYAN)
        var ball = Ball(Point(MAX_X/2, MAX_Y/2), VELOCITY)
        arena.draw(ball)
        arena.onTimeProgress(FRAME_RATE) {
        //arena.onKeyPressed { if (it.char=='A') {
            arena.erase()
            ball = ball.move()
            arena.draw(ball)

        }
        arena.onMouseDown { mouse ->
            val p = Point(mouse.x,mouse.y)
            ball = Ball(p, ball.dx)
        }
    }
    onFinish { }
}

fun Canvas.draw(b: Ball) {
    drawCircle(b.center.x, b.center.y, RADIUS, RED)
}
