import pt.isel.canvas.*

fun main() {
    onStart {
        val arena = Canvas(MAX_X, MAX_Y, CYAN)
        var ball = Ball(Point(MAX_X/2, MAX_Y/2), VELOCITY, RED)
        arena.draw(ball)
        arena.onTimeProgress(FRAME_RATE) {
        //arena.onKeyPressed { if (it.char=='A') {
            arena.erase()
            ball = ball.move()
            arena.draw(ball)

        }
        arena.onMouseDown { mouse ->
            val p = Point(mouse.x,mouse.y)
            ball = Ball(p, ball.dx, ball.color)
        }
    }
    onFinish { }
}
