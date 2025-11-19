import pt.isel.canvas.Canvas

/**
 * Draws the robot character at the specified cell position and direction.
 * @receiver The canvas on which to draw the robot.
 * @param a The robot position and direction to be drawn.
 */
fun Canvas.drawRobot(a: Actor) {
    val row = when(a.dir) {
        Dir.DOWN -> 0
        Dir.UP -> 3
        Dir.LEFT -> 1
        Dir.RIGHT -> 2
        else -> 0 // TODO
    }
    drawSprite(Sprites.ROBOT,Cell(row,0),a.pos)
}








