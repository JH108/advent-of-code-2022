package day02

import solve

private fun part1Test(lines: List<String>): Int {
    val rounds = lines.toRounds()

   return rounds.sumOf { it.score }
}

private fun part2Test(lines: List<String>): Int {
    val rounds = lines.toStrategicRounds()

    return rounds.sumOf { it.score }
}

fun main() = solve { lines ->
    val input = lines
    val part1Expected = 15
    val part2Expected = 12
    val part1Actual = part1Test(input)
    val part2Actual = part2Test(input)

    println("part1Expected == part1Actual: ${part1Expected == part1Actual}")
    println("part2Expected == part2Actual: ${part2Expected == part2Actual}")

    part1Expected == part1Actual && part2Expected == part2Actual
}
