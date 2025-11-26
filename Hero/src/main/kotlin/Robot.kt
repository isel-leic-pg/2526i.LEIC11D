import pt.isel.canvas.Canvas

const val MAX_ROBOTS = 10 // GRID_HEIGHT*GRID_WIDTH-2

/**
 * Draws the robot character at the specified cell position and direction.
 * @receiver The canvas on which to draw the robot.
 * @param a The robot position and direction to be drawn.
 */
fun Canvas.drawRobot(a: Actor) {
    val row = when(a.dir) {
        Dir.DOWN -> 0
        Dir.UP -> 3
        Dir.LEFT -> 1
        Dir.RIGHT -> 2
        else -> 0 // TODO
    }
    drawSprite(Sprites.ROBOT,Cell(row,0),a.pos)
}

/*fun randomRobots(exclude: Cell): List<Actor> {
    val robots: MutableList<Cell> = mutableListOf()
    while( robots.size < MAX_ROBOTS ) {
        val rnd = Cell( (0..<GRID_HEIGHT).random(), (0..<GRID_WIDTH).random() )
        if (rnd != exclude && rnd !in robots)
           robots.add(rnd)
        else print('#')
    }
    return robots.map{ Actor(it, Dir.DOWN) }
}*/


/*fun randomRobots(exclude: Cell): List<Actor> {
    var cells = allCells - exclude
    var robots = emptyList<Cell>()
    repeat (MAX_ROBOTS) {
        val rnd = cells.random()
        cells = cells - rnd
        robots = robots + rnd
    }
    return robots.map { Actor(it, Dir.DOWN) }
}*/

/**
 * Generates a list of random robot actors, excluding a specified cell.
 * @param exclude The cell to exclude from robot placement.
 * @return A list of actors placed in random cells without overlapping.
 */
fun randomRobots(exclude: Cell): List<Actor> = (allCells - exclude)
        .shuffled()
        .take(MAX_ROBOTS)
        .map { Actor(it, Dir.DOWN) }


/*fun List<Actor>.collisions(): List<Cell> {
    val positions = map{ it.pos }
    var reps = emptyList<Cell>()
    for(i in positions.indices) {
        val p = positions[i]
        for(j in 0..<i)
            if (p==positions[j] && p !in reps)
                reps = reps + p
    }
    return reps
}*/

/**
 * Identifies cells where multiple actors occupy the same position.
 * @receiver A list of actors to check for collisions.
 * @return A list of cells where collisions occur.
 */
fun List<Actor>.collisions(): List<Cell> = map{ it.pos }
    .distinct()
    .filter { p -> count { p==it.pos } > 1 }





