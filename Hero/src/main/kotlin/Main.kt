import pt.isel.canvas.*

/**
 * Simple canvas-based application that allows moving a hero character within a grid using arrow keys.
 */
fun main() {
    onStart {
        val arena = Canvas(GRID_WIDTH*CELL_SIZE, GRID_HEIGHT*CELL_SIZE, BLACK)
        var game = Game()
        arena.update(game)
        arena.onKeyPressed { key ->
            if (!game.isOver()) {
                val dir = key.toDir()
                if (dir != null)  game = game.moveHero(dir)
                if (key.char == '*') game = game.jumpHero()
                arena.update(game)
            }
        }
    }
    onFinish {  }
}

/**
 * Updates the canvas view by erasing it, drawing the grid,
 * and drawing the hero, all robots and garbage.
 * @receiver The canvas to update.
 * @param g The current game state.
 */
private fun Canvas.update(g: Game) {
    erase()
    drawGrid()
    drawHero(g.hero)
    g.robots.forEach { drawRobot(it) }
    g.garbage.forEach { drawCell("garbage.png",it) }
    if (g.isOver()) {
        val txt = if (g.heroIsDead()) "GAME OVER" else "You WIN"
        drawText(width/2-(20*txt.length/2), height/2, txt, WHITE )
    }
}

