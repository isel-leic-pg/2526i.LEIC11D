import pt.isel.canvas.*

fun main() {
    onStart {
        val arena = Canvas(600, 400, CYAN)
        arena.drawCircle(
            xCenter = arena.width/2,
            yCenter = arena.height/2,
            radius = 100,
            color = RED
        )
        arena.onMouseDown { me ->
            arena.drawCircle(me.x, me.y, 5, BLACK)
        }
        arena.onMouseMove { me ->
            if (me.down)
                arena.drawRect(me.x,me.y,10,10,BLUE)
        }
        arena.onKeyPressed {
            println(it)
        }
    }
    onFinish {
        println("Bye.")
    }
}
