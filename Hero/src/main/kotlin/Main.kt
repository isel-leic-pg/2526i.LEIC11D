import pt.isel.canvas.*

const val CELL_SIZE = 128
const val GRID_WIDTH = 11
const val GRID_HEIGHT = 7

/**
 * Simple canvas-based application that allows moving a hero character within a grid using arrow keys.
 */
fun main() {
    onStart {
        val arena = Canvas(GRID_WIDTH*CELL_SIZE, GRID_HEIGHT*CELL_SIZE, BLACK)
        var pos = Cell(GRID_HEIGHT/2,GRID_WIDTH/2)
        arena.drawGrid()
        arena.drawHero(pos)
        arena.onKeyPressed { key ->
            pos = when(key.code) {
                LEFT_CODE -> Cell(pos.row, pos.col-1)
                RIGHT_CODE -> Cell(pos.row, pos.col+1)
                UP_CODE -> Cell(pos.row-1, pos.col)
                DOWN_CODE -> Cell(pos.row+1, pos.col)
                else -> pos
            }
            arena.erase()
            arena.drawGrid()
            arena.drawHero(pos)
        }
    }
    onFinish {  }
}

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

/**
 * Represents a cell in the grid with row and column indices.
 * @property row The row index of the cell.
 * @property col The column index of the cell.
 */
data class Cell(val row: Int, val col: Int)

/**
 * Draws a grid on the canvas.
 * @receiver The canvas on which to draw the grid.
 */
fun Canvas.drawGrid() {
    for(x in 0..<width step CELL_SIZE)
        drawLine(x,0, x,height, YELLOW, 1)
    repeat(GRID_HEIGHT) {
        val y = it * CELL_SIZE
        drawLine(0,y, width,y, YELLOW, 1)
    }
}
