/**
 * Data classes representing the game state.
 * Includes the hero, robots, and garbage positions.
 */
data class Game(
    val hero: Actor = Actor(Cell(GRID_HEIGHT/2,GRID_WIDTH/2), Dir.DOWN),
    val robots: List<Actor> = listOf(Actor(Cell(0,0),Dir.DOWN)),
    val garbage: List<Cell> = listOf(Cell(0,1)),
)

/**
 * Moves the hero in the specified direction and returns a new game state.
 * @receiver The current game state.
 * @param dir The direction to move the hero.
 * @return A new game state with the hero moved.
 */
fun Game.moveHero(dir: Dir) = copy( hero = hero.move(dir) )