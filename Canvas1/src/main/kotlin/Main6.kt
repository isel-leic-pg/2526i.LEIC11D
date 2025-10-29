import pt.isel.canvas.*

const val MAX_X = 600
const val MAX_Y = 400
const val FRAME_RATE = 10 // in miliseconds

fun main() {
    onStart {
        val arena = Canvas(MAX_X, MAX_Y, CYAN)
        var balls: List<Ball> = listOf( Ball(Point(MAX_X/2, MAX_Y/2), VELOCITY, RED) )
        arena.onTimeProgress(FRAME_RATE) {
            arena.erase()
            balls = balls.map{ it.move() }
            balls.forEach { arena.draw(it) }
            arena.drawText(MAX_X/2, MAX_Y/2, "${balls.size}", YELLOW)
        }
        arena.onMouseDown { mouse ->
            val p = Point(mouse.x,mouse.y)
            val clicked = balls.filter{ it.isIn(p) }
            balls = if (clicked.isNotEmpty())
                balls - clicked
            else
                balls + Ball(p, (-VELOCITY..VELOCITY).random(), (0..0xFFFFFF).random())
        }
    }
    onFinish { }
}

//fun List<Ball>.firstBallIn(p :Point): Ball? = firstOrNull{ it.isIn(p) }
/*{
    for(b in this) {
        if (b.isIn(p))
            return b
    }
    return null
}*/

