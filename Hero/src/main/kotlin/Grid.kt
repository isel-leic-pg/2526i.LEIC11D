import pt.isel.canvas.Canvas
import pt.isel.canvas.YELLOW

const val CELL_SIZE = 128
const val GRID_WIDTH = 11
const val GRID_HEIGHT = 7

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

fun Cell.isInGrid() = row in 0..<GRID_HEIGHT && col in 0..<GRID_WIDTH