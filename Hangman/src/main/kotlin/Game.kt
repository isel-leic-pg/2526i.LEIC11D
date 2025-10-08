
const val MAX_ERRORS = 6

fun main() {
    var errors = 0
    val secret = "PROGRAMA"
    var word: List<Char> = secret.map{ '_' }
    var used = ""
    printErrors(errors)
    do {
        println(word.joinToString(" "))
        val guess = readGuess(used)
        used += guess
        if (guess in secret) {
            word = update(secret,word,guess)
        } else {
            errors++
            printErrors(errors)
        }
    } while (errors < MAX_ERRORS && !completed(word))
}

fun update(s: String, w: List<Char>, c: Char): List<Char> {
    var res: List<Char> = emptyList()
    for(idx in s.indices) {
        if (s[idx] == c) res = res + c
        else res = res + w[idx]
    }
    return res
}

fun printErrors(n: Int) {
    println("Erros: $n")
}

fun completed(w: List<Char>): Boolean {
    return false
}

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






