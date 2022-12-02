package day24

import solve

private fun part1Test(lines: List<String>): Int? {
    TODO()
}

private fun part2Test(lines: List<String>): Int? {
    TODO()
}

fun main() = solve { lines ->
    val input = lines
    val part1Expected = 1
    val part2Expected = 1
    val part1Actual = part1Test(input)
    val part2Actual = part2Test(input)

    println("part1Expected == part1Actual: ${part1Expected == part1Actual}")
    println("part2Expected == part2Actual: ${part2Expected == part2Actual}")

    part1Expected == part1Actual && part2Expected == part2Actual
}