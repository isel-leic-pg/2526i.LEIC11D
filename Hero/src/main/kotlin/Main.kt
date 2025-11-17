import pt.isel.canvas.*

/**
 * Simple canvas-based application that allows moving a hero character within a grid using arrow keys.
 */
fun main() {
    onStart {
        val arena = Canvas(GRID_WIDTH*CELL_SIZE, GRID_HEIGHT*CELL_SIZE, BLACK)
        var hero = Actor(Cell(GRID_HEIGHT/2,GRID_WIDTH/2), Dir.DOWN)
        arena.update(hero)
        arena.onKeyPressed { key ->
            val dir = key.toDir()
            if (dir!=null) {
                val h = hero.move(dir)
                if (h!=hero) {
                    hero = h
                    arena.update(hero)
                }
            }
        }
    }
    onFinish {  }
}

data class Actor(val pos: Cell, val dir: Dir)

fun Actor.move(to: Dir): Actor {
    val destination = pos + to
    return if (!destination.isInGrid()) copy(dir = to)
           else Actor(destination, to)
}

/**
 * Updates the canvas view by erasing it, drawing the grid, and drawing the hero at the specified position.
 * @param this@update The canvas to update.
 * @param pos The position of the hero.
 */
private fun Canvas.update(h: Actor) {
    erase()
    drawGrid()
    drawHero(h)
}

