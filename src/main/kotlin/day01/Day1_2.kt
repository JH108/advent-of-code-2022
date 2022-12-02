package day01

import solve

fun main() = solve { lines ->
    val elves = lines.buildElves()
    val topThreeElves = elves.sortedByDescending { it.totalCalories }.take(3)

    topThreeElves.sumOf { it.totalCalories }
}
