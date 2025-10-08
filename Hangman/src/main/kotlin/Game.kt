
const val MAX_ERRORS = 6

fun main() {
    val secret = words.random().uppercase()
    val secret2 = removePontuation(secret)
    var word: List<Char> = secret.map{ '_' }
    var used = ""
    var errors = 0
    printGallows(errors)
    do {
        println(word.joinToString(" "))
        val guess = readGuess(used)
        used += guess
        if (guess in secret2)
            word = update(secret,secret2,word,guess)
        else
            printGallows(++errors)
    } while (errors < MAX_ERRORS && !completed(word))

    val status = if (errors==MAX_ERRORS) "LOSE" else "WIN"
    println("YOU $status -> ${secret.toList().joinToString(" ")}")
}

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

fun update(s: String, s2: String, w: List<Char>, c: Char): List<Char> =
    w.mapIndexed { idx, it ->
        if (s2[idx] == c) s[idx] else it
    }
/*{
    var res: List<Char> = emptyList()
    for(idx in s.indices) {
        if (s2[idx] == c) res = res + s[idx]
        else res = res + w[idx]
    }
    return res
}*/

fun completed(w: List<Char>): Boolean = w.none{ it=='_' }
/*{
    for (c in w)
        if (c == '_') return false
    return true
}*/

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






