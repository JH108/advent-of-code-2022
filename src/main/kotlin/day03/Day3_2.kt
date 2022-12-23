package day03

import solve

fun main() = solve { lines ->
    lines.chunked(3).map {
        val (first, second, third) = it

        Rucksack(first = first, second = second, third = third)
    }.sumOf {
        it.findDuplicate()
    }
}
