import kotlin.test.*

// Assumes RADIUS=50

class IsInTests {
    @Test
    fun pointInsideBallReturnsTrue() {
        val ball = Ball(Point(5, 5), 0, 0)
        val point = Point(10, 5)
        assertEquals(true, ball.isIn(point))
    }

    @Test
    fun pointOnBallEdgeReturnsTrue() {
        val ball = Ball(Point(5, 5), 0, 0)
        val point = Point(55, 5)
        assertEquals(true, ball.isIn(point))
    }

    @Test
    fun pointOutsideBallReturnsFalse() {
        val ball = Ball(Point(5, 5), 0, 0)
        val point = Point(60, 5)
        assertEquals(false, ball.isIn(point))
    }
}