import pt.isel.canvas.*

/**
 * Simple canvas-based application that allows moving a hero character within a grid using arrow keys.
 */
fun main() {
    onStart {
        val arena = Canvas(GRID_WIDTH*CELL_SIZE, GRID_HEIGHT*CELL_SIZE, BLACK)
        var pos = Cell(GRID_HEIGHT/2,GRID_WIDTH/2)
        updateView(arena,pos)
        arena.onKeyPressed { key ->
            val dir = key.toDir()
            if (dir!=null && (pos+dir).isInGrid()) {
                pos += dir
                updateView(arena, pos)
            }
        }
    }
    onFinish {  }
}

enum class Dir { LEFT, RIGHT, UP, DOWN }

operator fun Cell.plus(dir: Dir): Cell = when(dir) {
    Dir.LEFT -> Cell(row,col-1)
    Dir.RIGHT -> Cell(row,col+1)
    Dir.UP -> Cell(row-1,col)
    Dir.DOWN -> Cell(row+1,col)
}

fun KeyEvent.toDir(): Dir? = when(code) {
    LEFT_CODE -> Dir.LEFT
    RIGHT_CODE -> Dir.RIGHT
    UP_CODE -> Dir.UP
    DOWN_CODE -> Dir.DOWN
    else -> null
}

private fun updateView(arena: Canvas, pos: Cell) {
    arena.erase()
    arena.drawGrid()
    arena.drawHero(pos)
}

