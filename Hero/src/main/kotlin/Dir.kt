import pt.isel.canvas.*
import Dir.*

/**
 * Represents a direction for moving the hero.
 */
enum class Dir(val dRow: Int, val dCol: Int) {
    LEFT(0,-1), RIGHT(0,+1), UP(-1,0), DOWN(+1,0),
    UP_LEFT(-1,-1), UP_RIGHT(-1,+1), DOWN_LEFT(+1,-1), DOWN_RIGHT(+1,+1)
}

fun Dir.isDiagonal() = dRow != 0 && dCol != 0

/**
 * Adds a direction to a cell, returning a new cell in the specified direction.
 *
 * Can be used like an operator: cell + dir
 * @receiver The original cell.
 * @param dir The direction to move.
 * @return A new cell moved in the specified direction.
 */
operator fun Cell.plus(dir: Dir): Cell = Cell(row+dir.dRow, col+dir.dCol)

/**
 * Key codes for diagonal direction keys.
 */
const val PGUP_CODE = 33
const val PGDOWN_CODE = 34
const val END_CODE = 35
const val HOME_CODE = 36

/**
 * Converts a KeyEvent to a Dir if it corresponds to a direction key.
 * @receiver The KeyEvent to convert.
 * @return The corresponding Dir or null if the key is not a direction.
 */
fun KeyEvent.toDir(): Dir? = when(code) {
    LEFT_CODE -> LEFT
    RIGHT_CODE -> RIGHT
    UP_CODE -> UP
    DOWN_CODE -> DOWN
    HOME_CODE -> UP_LEFT
    PGUP_CODE -> UP_RIGHT
    PGDOWN_CODE -> DOWN_RIGHT
    END_CODE -> DOWN_LEFT
    else -> null
}

fun main() {
    for(d in Dir.entries)
        println(d.ordinal)
}