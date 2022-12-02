package day01

import solve

fun part1Test(elves: List<CalorieElf>): Int? {
    val bestFedElf = elves.maxByOrNull { it.totalCalories }

    return bestFedElf?.totalCalories
}

fun part2Test(elves: List<CalorieElf>): Int? {
    val topThreeElves = elves.sortedByDescending { it.totalCalories }.take(3)

    return topThreeElves.sumOf { it.totalCalories }
}

fun main() = solve { lines ->
    val elves = lines.buildElves()
    val part1Expected = 24000
    val part2Expected = 45000
    val part1Actual = part1Test(elves)
    val part2Actual = part2Test(elves)

    assert(part1Expected == part1Actual)
    assert(part2Expected == part2Actual)

    true
}
