/**
 * Lê uma tentativa e só retorna quando quando a letra ainda não foi utilizada.
 * @param used As letras já utilizdas nas tentaivas
 * @return A letra introduzida pelo utilizador
 */
fun readGuess(used: String): Char {
    while (true) {
        print("$used: ")
        val line = readln().trim()
        if (line.length == 1) {
            val c = line[0].uppercaseChar()
            if (c !in used) return c
        }
        println("Invalid guess $line")
    }
}
