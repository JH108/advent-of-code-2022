package day02

import solve

private fun part1Test(lines: List<String>): Int {
    val rounds = lines.toRounds()

   return rounds.sumOf { it.score }
}

private fun part2Test(lines: List<String>): Int {
    return 3
}

fun main() = solve { lines ->
    val input = lines
    val part1Expected = 15
    val part2Expected = 1
    val part1Actual = part1Test(input)
    val part2Actual = part2Test(input)

    assert(part1Expected == part1Actual)
    assert(part2Expected == part2Actual)

    true
}
