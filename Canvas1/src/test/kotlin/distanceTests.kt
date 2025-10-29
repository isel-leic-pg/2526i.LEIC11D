import kotlin.test.*

class DistanceTests {

    @Test
    fun distanceBetweenSamePointsIsZero() {
        val point = Point(3, 4)
        assertEquals(0.0, distance(point, point))
    }

    @Test
    fun distanceBetweenPointsOnXAxis() {
        val pointA = Point(1, 0)
        val pointB = Point(4, 0)
        assertEquals(3.0, distance(pointA, pointB))
    }

    @Test
    fun distanceBetweenPointsOnYAxis() {
        val pointA = Point(0, 2)
        val pointB = Point(0, 5)
        assertEquals(3.0, distance(pointA, pointB))
    }

    @Test
    fun distanceBetweenDiagonalPoints() {
        val pointA = Point(0, 0)
        val pointB = Point(3, 4)
        assertEquals(5.0, distance(pointA, pointB))
    }
}
