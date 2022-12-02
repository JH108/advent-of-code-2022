package day01

import solve

fun main() = solve { lines ->
    val elves = lines.buildElves()
    val bestFedElf = elves.maxByOrNull { it.totalCalories }

    bestFedElf?.totalCalories
}
