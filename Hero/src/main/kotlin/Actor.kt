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