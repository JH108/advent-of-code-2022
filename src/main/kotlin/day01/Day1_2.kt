package day01

import solve

fun attempt1(lines: List<String>) {
    val elves = lines.buildElves()
    var remainingElves = elves
    var outputElves = listOf<CalorieElf>()

    repeat(3) {
        val bestFedElf = remainingElves.maxByOrNull { it.totalCalories }
        bestFedElf?.run {
            outputElves = outputElves + bestFedElf
            remainingElves = remainingElves - bestFedElf
        }
    }

    outputElves.sumOf { it.totalCalories }
}

fun attempt2(lines: List<String>) {
    val elves = lines.buildElves()
    val topThreeElves = elves.sortedByDescending { it.totalCalories }.take(3)

    topThreeElves.sumOf { it.totalCalories }
}

fun main() = solve { lines ->
    val elves = lines.buildElves()
    val topThreeElves = elves.sortedByDescending { it.totalCalories }.take(3)

    topThreeElves.sumOf { it.totalCalories }
}
