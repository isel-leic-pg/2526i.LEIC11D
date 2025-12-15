/**
 * Example of searching for an element in a list using different algorithms.
 * Demonstrates linear search and binary search (iterative and recursive).
 */

fun main() {
    val l = List(20) { ('A'..'Z').random() }
    println(l)
    val idx = l.idxOf('P')
    println("Index of P = $idx")

    val sl = l.sorted()
    println(sl)
    val idx2 = sl.idxOfBin('P')
    println("Index of P = $idx2")
    val idx3 = sl.idxOfBinR('P')
    println("Index of P = $idx3")
}

/**
 * Finds the index of the first occurrence of a character in the list.
 * Using a linear (sequential) search algorithm.
 * @receiver The list of characters to search.
 * @param e The character to find.
 * @return The index of the character if found, otherwise -1.
 */
fun List<Char>.idxOf(e: Char): Int {
    for(i in indices) {
        print('#')
        if (this[i] == e)
            return i
    }
    return -1
}

/**
 * The same as idxOf but using an iterative version of binary search algorithm.
 * Assumes the list is sorted in ascending order.
 */
fun List<Char>.idxOfBin(e: Char): Int {
    var from = 0
    var to = lastIndex
    while(from <= to){
        val mid = (from+to)/2
        val m = this[mid]
        print('#')
        when {
            e == m -> return mid
            e < m -> to = mid-1
            else -> from = mid+1
        }
    }
    return -1
}

/**
 * The same as idxOf but using a recursive version of binary search algorithm.
 * Assumes the list is sorted in ascending order.
 */
fun List<Char>.idxOfBinR(e: Char, from: Int=0, to: Int=lastIndex): Int {
    if (from > to) return -1
    val mid = (from+to)/2
    val m = this[mid]
    print('#')
    return when {
        e == m -> mid
        e < m -> idxOfBinR(e,from,mid-1)
        else -> idxOfBinR(e,mid+1,to)
    }
}

