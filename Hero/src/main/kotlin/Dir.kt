import pt.isel.canvas.DOWN_CODE
import pt.isel.canvas.KeyEvent
import pt.isel.canvas.LEFT_CODE
import pt.isel.canvas.RIGHT_CODE
import pt.isel.canvas.UP_CODE

/**
 * Represents a direction for moving the hero.
 */
enum class Dir { LEFT, RIGHT, UP, DOWN }

/**
 * Adds a direction to a cell, returning a new cell in the specified direction.
 *
 * Can be used like an operator: cell + dir
 * @receiver The original cell.
 * @param dir The direction to move.
 * @return A new cell moved in the specified direction.
 */
operator fun Cell.plus(dir: Dir): Cell = when(dir) {
    Dir.LEFT -> Cell(row,col-1)
    Dir.RIGHT -> Cell(row,col+1)
    Dir.UP -> Cell(row-1,col)
    Dir.DOWN -> Cell(row+1,col)
}

/**
 * Converts a KeyEvent to a Dir if it corresponds to an arrow key.
 * @receiver The KeyEvent to convert.
 * @return The corresponding Dir or null if the key is not an arrow key.
 */
fun KeyEvent.toDir(): Dir? = when(code) {
    LEFT_CODE -> Dir.LEFT
    RIGHT_CODE -> Dir.RIGHT
    UP_CODE -> Dir.UP
    DOWN_CODE -> Dir.DOWN
    else -> null
}