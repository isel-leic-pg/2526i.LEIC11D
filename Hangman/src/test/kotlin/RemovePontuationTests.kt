import kotlin.test.*

class RemovePontuationTests {
    @Test
    fun removeAccentOfA() {
        val res = removePontuation("ÁÀ")
        assertEquals("AA",res)
    }
    @Test
    fun withAndWithoutAccents() {
        val input = "AÇÃO"
        val expected = "ACAO"
        assertEquals(expected, removePontuation(input))
    }
}