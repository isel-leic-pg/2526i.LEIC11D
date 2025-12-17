

/**
 * Data classes representing the game state.
 * Includes the hero, robots, and garbage positions.
 */
data class Game(
    val hero: Actor = Actor(Cell(GRID_HEIGHT/2,GRID_WIDTH/2), Dir.DOWN),
    val robots: List<Actor> = randomRobots(hero.pos),
    val garbage: List<Cell> = emptyList(),
)

/**
 * Moves the hero in the specified direction,
 * and moves all robots one step towards the new hero position.
 * A new game state is returned with the updated positions.
 * @receiver The current game state.
 * @param dir The direction to move the hero.
 * @return A new game state with updated positions.
 */
fun Game.moveHero(dir: Dir): Game {
    val newHero = hero.move(dir)
    val newRobots = robots.map { it.moveTo(newHero.pos) }
    val collisions: List<Cell> = newRobots.collisions()
    val newGarbage = garbage + collisions
    return Game(
        hero = newHero,
        robots = newRobots.filter{ it.pos !in newGarbage } ,
        garbage = newGarbage
    )
}

fun Game.heroIsDead() = hero.pos in garbage || robots.any{ it.pos == hero.pos }

fun Game.isOver() = robots.isEmpty() || heroIsDead()

fun Game.jumpHero(): Game {
    val freePos = (allCells - garbage).filter { p -> robots.all{ r -> r.pos != p } }.random()
    return copy(hero = hero.copy(pos = freePos))
}

