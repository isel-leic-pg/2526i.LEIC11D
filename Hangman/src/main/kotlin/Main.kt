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

