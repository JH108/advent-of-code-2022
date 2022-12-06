package day03

import solve

data class Rucksack(
    val compartments: Pair<String, String>
) {
    private val firstRepeatedSupplies
        get() = compartments.first
            .split("")
            .map { it.single() }
            .sortedByDescending { it.code }
            .fold(mapOf<Char, Int>()) { map, code ->
                val count = map.getOrDefault(code, 0)

                if (count == 0) {
                    map + mapOf(code to count + 1)
                } else {
                    map + mapOf(code to 1)
                }
            }.entries.first { it.value > 1 }

    private val secondRepeatedSupplies
        get() = compartments.second
            .split("")
            .map { it.single() }
            .sortedByDescending { it.code }
            .fold(mapOf<Char, Int>()) { map, code ->
                val count = map.getOrDefault(code, 0)

                if (count == 0) {
                    map + mapOf(code to count + 1)
                } else {
                    map + mapOf(code to 1)
                }
            }.entries.first { it.value > 1 }

    val repeatedSupplies
        get() = listOf(firstRepeatedSupplies.key.code, secondRepeatedSupplies.key.code)
}

// vJrwpWtwJgWrhcsFMMfFFhFp
// first vJrwpWtwJgWr
// second hcsFMMfFFhFp
fun main() = solve { lines ->
    val rucksacks = lines.map {
        val firstHalf = it.take(it.length / 2)
        val secondHalf = it.takeLast(it.length / 2)

        Rucksack(compartments = firstHalf to secondHalf)
    }
    val result = rucksacks.fold(0) { count, rucksack ->
        count + rucksack.repeatedSupplies.first()
    }

    result
}
