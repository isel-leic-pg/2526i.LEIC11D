

fun main() {
    val start = readChar("Start char")
    val end = readChar("End char", start..'Z')
    for( c in start..end)
        println("$c - ${c.code}")
}

fun readChar(quest: String, valid: CharRange = 'A'..'Z'): Char {
    while(true) {
        print("$quest ? ")
        val c = readln().trim()[0]
        if (c in valid) return c
        println("Invalid $c")
    }
}