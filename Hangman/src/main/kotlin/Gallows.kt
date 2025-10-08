fun main() {
    for (errors in gallows.indices)
        printGallows(errors)
}

fun printGallows(numberOfparts: Int) {
    println(gallows[numberOfparts].trimIndent())
}

val gallows = listOf(
""" 
 +---.
     |
     |
     |
=======
""",""" 
 +---.
 O   |
     |
     |
=======
""",""" 
 +---.
 O   |
 |   |
     |
=======
""",""" 
 +---.
 O   |
/|   |
     |
=======
""",""" 
 +---.
 O   |
/|\  |
     |
=======
""",""" 
 +---.
 O   |
/|\  |
/    |
=======
""",""" 
 +---.
 O   |
/|\  |
/ \  |
=======
"""
)
