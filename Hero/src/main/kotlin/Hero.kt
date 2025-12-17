import pt.isel.canvas.Canvas

/**
 * Draws the hero character at the specified cell position and direction.
 * @receiver The canvas on which to draw the hero.
 * @param a The hero position and direction to be drawn.
 */
fun Canvas.drawHero(a: Actor) {
    val row = when(a.dir) {
        Dir.DOWN, Dir.DOWN_LEFT -> 0
        Dir.LEFT, Dir.UP_LEFT -> 1
        Dir.RIGHT, Dir.DOWN_RIGHT -> 2
        Dir.UP, Dir.UP_RIGHT -> 3
    }
    val col = if (a.dir.isDiagonal()) 4 else 1
    drawSprite(Sprites.HERO,Cell(row,col),a.pos)
}









