import pt.isel.canvas.Canvas


/**
 * Enumeration of sprite types with their corresponding image file names and size of each square/sprite.
 */
enum class Sprites(val file: String, val size: Int){
    ROBOT("robot.png", 64),
    HERO("hero.png", 48)
}

/**
 * Draws a specific sprite from a spritesheet at the given cell position on the canvas.
 * @receiver The canvas on which to draw the sprite.
 * @param sprites The spritesheet containing the sprite.
 * @param sprite The cell specifying the row and column of the sprite in the spritesheet.
 * @param pos The cell position where the sprite should be drawn on the canvas.
 */
fun Canvas.drawSprite(sprites: Sprites, sprite: Cell, pos: Cell) {
    val ss = sprites.size
    val image = "${sprites.file}|${sprite.col*ss},${sprite.row*ss},$ss,$ss"
    drawCell(image,pos)
}