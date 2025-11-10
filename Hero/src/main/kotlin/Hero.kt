import pt.isel.canvas.Canvas

/**
 * Draws the hero character at the specified cell position on the canvas.
 * @receiver The canvas on which to draw the hero.
 * @param p The cell position where the hero should be drawn.
 */
fun Canvas.drawHero(p: Cell) {
    drawImage(
        fileName = "hero|48,0,48,48",
        xLeft = p.col*CELL_SIZE,
        yTop = p.row*CELL_SIZE,
        width = CELL_SIZE,
        height = CELL_SIZE
    )
}