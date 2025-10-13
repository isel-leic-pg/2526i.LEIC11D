import kotlin.test.*

class UpdateTests {
    @Test
    fun pgTest() {
        val secret = "PG"
        val initWord = listOf('_','G')
        val expected = listOf('P','G')
        assertEquals(expected, update(secret,secret,initWord,'P'))
    }
}