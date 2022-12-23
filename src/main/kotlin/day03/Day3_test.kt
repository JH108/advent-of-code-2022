package day03

import solve

private fun part1Test(lines: List<String>): Int? {
    val rucksacks = lines.map {
        val firstHalf = it.take(it.length / 2)
        val secondHalf = it.takeLast(it.length / 2)
        println("FirstHalf: $firstHalf")
        println("SecondHalf: $secondHalf")

        Rucksack(first = firstHalf, second = secondHalf)
    }
    val result = rucksacks.fold(0) { count, rucksack ->
        val dupe = rucksack.findDuplicate()
        // 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s); the sum of these is 157.
        println("Dup: $dupe")
        count + dupe
    }
    println("Result: $result")

    return result
}

private fun part2Test(lines: List<String>): Int? {
    return lines.chunked(3).map {
        val (first, second, third) = it
        Rucksack(first = first, second = second, third = third)
    }.sumOf {
        println("Dupe: ${it.findDuplicate()}")
        it.findDuplicate()
    }
}

fun main() = solve { lines ->
    val input = lines
    val part1Expected = 157
    val part2Expected = 70
    val part1Actual = part1Test(input)
    val part2Actual = part2Test(input)

    println("part1Expected == part1Actual: ${part1Expected == part1Actual}")
    println("part2Expected == part2Actual: ${part2Expected == part2Actual}")
    println("part2Actual: $part2Actual")

    part1Expected == part1Actual && part2Expected == part2Actual
}
