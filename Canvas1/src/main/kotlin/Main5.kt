import pt.isel.canvas.*


fun main() {
    onStart {
        val arena = Canvas(MAX_X, MAX_Y, CYAN)
        var balls = listOf( Ball(Point(MAX_X/2, MAX_Y/2), VELOCITY, RED) )
        arena.onTimeProgress(FRAME_RATE) {
            arena.erase()
            balls = balls.map{ it.move() }
            balls.forEach { arena.draw(it) }
            arena.drawText(MAX_X/2, MAX_Y/2, "${balls.size}", YELLOW)
        }
        arena.onMouseDown { mouse ->
            val p = Point(mouse.x,mouse.y)
            balls = balls + Ball(p, VELOCITY, (0..0xFFFFFF).random())
        }
    }
    onFinish { }
}

