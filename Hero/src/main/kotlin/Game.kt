/**
 * Data classes representing the game state.
 * Includes the hero, robots, and garbage positions.
 */
data class Game(
    val hero: Actor = Actor(Cell(GRID_HEIGHT/2,GRID_WIDTH/2), Dir.DOWN),
    val robots: List<Actor> = listOf(
        Actor(Cell(0,0),Dir.DOWN),
        Actor(Cell(1,1),Dir.RIGHT)
    ),
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
    return copy(
        hero = h,
        robots = robots.map { it.moveTo(h.pos) }
    )
}