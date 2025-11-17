import pt.isel.canvas.Canvas

const val SPRITE_SIZE = 48

/**
 * Draws the hero character at the specified cell position and direction.
 * @receiver The canvas on which to draw the hero.
 * @param a The hero position and direction to be drawn.
 */
fun Canvas.drawHero(a: Actor) {
    val ss = SPRITE_SIZE
    val row = when(a.dir) {
        Dir.DOWN -> 0
        Dir.UP -> 3
        Dir.LEFT -> 1
        Dir.RIGHT -> 2
    }
    drawImage(
        fileName = "hero|$ss,${ss*row},$ss,$ss",
        xLeft = a.pos.col*CELL_SIZE,
        yTop = a.pos.row*CELL_SIZE,
        width = CELL_SIZE,
        height = CELL_SIZE
    )
}