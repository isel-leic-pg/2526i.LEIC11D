

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
    val h = hero.move(dir)
    val r = robots.map { it.moveTo(h.pos) }
    val collisions: List<Cell> = r.collisions()
    return Game(
        hero = h,
        robots = r.filter{ it.pos !in collisions } ,
        garbage = garbage + collisions
    )
}





