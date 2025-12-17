

enum class Suit(val sym: Char) {
    H('♥'), D('♦'), C('♣'), S('♠')
}

data class Card(
    val value: Char,
    val suit: Suit
)

const val VALUES = "234567JQKA"

val hand = listOf(
    Card('A',Suit.H),
    Card('J',Suit.S),
    Card('4',Suit.C),
    Card('X',Suit.S)
)

fun validCard( c: Card ): Boolean =
    c.value in VALUES

fun Card.toText(): String =
    if ( validCard( this ) ) "$value${suit.sym}"  else "??"

fun Card.isBetterThan(other: Card): Boolean =
    suit == other.suit &&
    validCard(this) && validCard(other) &&
    VALUES.indexOf(value) > VALUES.indexOf(other.value)

fun main() {
    println(validCard(Card('A',Suit.H)))
    println(validCard(Card('X',Suit.S)))
    println(hand.map{ it.toText() })
    println(hand.dropLast(1).map{ Card('K',Suit.C).isBetterThan(it) })
}