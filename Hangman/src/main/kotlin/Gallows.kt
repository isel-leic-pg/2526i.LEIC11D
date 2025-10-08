fun main() {
    for (errors in gallows.indices)
        println(gallows[errors].trimIndent())
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
