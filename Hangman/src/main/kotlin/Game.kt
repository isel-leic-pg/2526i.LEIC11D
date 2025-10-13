
/**
 * Retira os acentos e as cedilhas das letras.
 * @param s Palavra a considerar
 * @return A palavra sen acentos e cedilhas
 */
fun removePontuation(s: String): String =
    s.map { when(it) {
        in "ÁÀÃÂ" -> 'A'
        in "ÉÈÊ"  -> 'E'
        in "ÍÌ"   -> 'I'
        in "ÓÒÕÔ" -> 'O'
        in "ÚÙ"   -> 'U'
        'Ç'       -> 'C'
        else -> it
    } }.joinToString("")

/**
 * Retorna o novo estado da palavra descoberta.
 * @param s A palvara escondida
 * @param s2 A palvara escondida sem acentos
 * @param w O estado atual da palavra a descobrir
 * @param c A letra da tentativa de descobrir
 * @return O estado atual da palavra a descobrir
 */
fun update(s: String, s2: String, w: List<Char>, c: Char): List<Char> =
    w.mapIndexed { idx, it ->
        if (s2[idx] == c) s[idx] else it
    }

/**
 * @param w Estado atual da palavra a descobrir.
 * @return true se o estado atual tem as letras todas descobertas.
 */
fun completed(w: List<Char>): Boolean = w.none{ it=='_' }







