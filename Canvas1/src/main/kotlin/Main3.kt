import pt.isel.canvas.*


fun main() {
    var point = Point(300,200)
    var dx = 5
    onStart {
        val arena = Canvas(600, 400, CYAN)
        arena.drawCircle(point.x,point.y,10,RED)
        arena.onTimeProgress(10) {
            if (point.x > arena.width-10 || point.x < 10) dx = -dx
            point = Point(point.x+dx,point.y)
            arena.erase()
            arena.drawCircle(point.x,point.y,10,RED)
        }
    }
    onFinish {
        println("Bye.")
    }
}
