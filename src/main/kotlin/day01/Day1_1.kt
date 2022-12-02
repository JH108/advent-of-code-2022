package day01

import solve

typealias Calories = Int

data class CalorieElf(
    private var _snacks: List<Calories>,
    val position: Int
) {
    val snacks
        get() = _snacks
    val totalCalories
        get() = _snacks.reduce { total, calories -> total + calories }

    fun addSnack(calories: Calories) {
        _snacks = _snacks + calories
    }
}

fun List<String>.buildElves(): List<CalorieElf> {
    var elves = listOf<CalorieElf>()
    var currentElf: CalorieElf? = null

    forEachIndexed { position, _snack ->
        val snack = _snack.toIntOrNull()

        if (snack != null) {
            if (currentElf == null) {
                currentElf = CalorieElf(_snacks = listOf(snack), position = position)
            } else {
                currentElf?.addSnack(snack)
            }
        } else {
            currentElf?.run {
                elves = elves + this
            }
            currentElf = null
        }

        if (position == this.lastIndex) {
            currentElf?.run {
                elves = elves + this
            }
        }
    }

    return elves
}

fun main() = solve { lines ->
    val elves = lines.buildElves()
    val bestFedElf = elves.maxByOrNull { it.totalCalories }

    bestFedElf?.totalCalories
}
