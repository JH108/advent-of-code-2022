package day03

import solve

fun String.getOrderedChars() = split("")
    .asSequence()
    .filter { it.isNotBlank() }
    .map { it.single() }
    .sortedByDescending { it.code }
    .toList()

data class Rucksack(
    val first: String,
    val second: String,
    val third: String? = null
) {
    private val firstChars = first.getOrderedChars()
    private val secondChars = second.getOrderedChars()
    private val thirdChars = third?.getOrderedChars()

    fun findDuplicate(): Int {
        for (char in firstChars) {
            if (char in secondChars && (third == null)) {
                val value = if (char - 'a' < 0) {
                    char - 'A' + 27
                } else {
                    char - 'a' + 1
                }

                return value
            } else if (thirdChars != null && char in secondChars && char in thirdChars) {
                val value = if (char - 'a' < 0) {
                    char - 'A' + 27
                } else {
                    char - 'a' + 1
                }

                return value
            }
        }

        return 0
    }
}

// vJrwpWtwJgWrhcsFMMfFFhFp
// first vJrwpWtwJgWr
// second hcsFMMfFFhFp
fun main() = solve { lines ->
    val rucksacks = lines.map {
        val firstHalf = it.take(it.length / 2)
        val secondHalf = it.takeLast(it.length / 2)

        Rucksack(first = firstHalf, second = secondHalf)
    }
    val result = rucksacks.fold(0) { count, rucksack ->
        count + rucksack.findDuplicate()
    }

    result
}
