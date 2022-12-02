package day02

import solve

fun String.convertToPlay(): RPCPlay = when (this) {
    "A", "X" -> RPCPlay.Rock
    "B", "Y" -> RPCPlay.Paper
    "C", "Z" -> RPCPlay.Scissors
    else -> throw Exception("Unknown Play")
}

data class Round(
    val elf: RPCPlay,
    val player: RPCPlay
) {
    private val winner = when {
        elf == player -> RoundResult.Draw
        elf greaterThan player -> RoundResult.ElfWin
        else -> RoundResult.PlayerWin
    }
    val score = player.toScore() + winner.toScore()
}

enum class RoundResult {
    Draw,
    ElfWin,
    PlayerWin
}

fun RoundResult.toScore() = when (this) {
    RoundResult.Draw -> 3
    RoundResult.ElfWin -> 0
    RoundResult.PlayerWin -> 6
}

enum class RPCPlay {
    Rock,
    Paper,
    Scissors
}

infix fun RPCPlay.greaterThan(other: RPCPlay) = when {
    this == RPCPlay.Rock && other == RPCPlay.Scissors -> true
    this == RPCPlay.Paper && other == RPCPlay.Rock -> true
    this == RPCPlay.Scissors && other == RPCPlay.Paper -> true
    else -> false
}

fun RPCPlay.toScore() = when (this) {
    RPCPlay.Rock -> 1
    RPCPlay.Paper -> 2
    RPCPlay.Scissors -> 3
}

internal fun List<String>.toRounds() = map {
    Round(
        elf = it.substringBefore(" ").convertToPlay(),
        player = it.substringAfter(" ").convertToPlay()
    )
}

fun main() = solve { lines ->
    val rounds = lines.toRounds()

    rounds.sumOf { it.score }
}
