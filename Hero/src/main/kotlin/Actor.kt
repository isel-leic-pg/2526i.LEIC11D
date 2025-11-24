import kotlin.math.abs

/**
 * Represents an actor in the grid with a position and direction.
 * @property pos The position of the actor in the grid.
 * @property dir The direction the actor is facing.
 */
data class Actor(val pos: Cell, val dir: Dir)

/**
 * Moves the actor in the specified direction if the destination is within the grid.
 * If the move went out of bounds, only updates the direction.
 * @receiver The actor to move.
 * @param to The direction to move.
 * @return A new actor with updated position and/or direction.
 */
fun Actor.move(to: Dir): Actor {
    val destination = pos + to
    return if (!destination.isInGrid()) copy(dir = to)
           else Actor(destination, to)
}

/**
 * Moves the actor one step towards the specified cell.
 * Chooses the direction based on the greater distance in rows or columns.
 * @receiver The actor to move.
 * @param to The target cell to move towards.
 * @return A new actor moved one step towards the target cell.
 */
fun Actor.moveTo(to: Cell): Actor {
    val dRow = abs(to.row - pos.row)
    val dCol = abs(to.col - pos.col)
    val dir = when {
        dRow >= dCol -> if (to.row > pos.row) Dir.DOWN else Dir.UP
        else -> if (to.col > pos.col) Dir.RIGHT else Dir.LEFT
    }
    return move(dir)
}