package day02

import solve

fun String.roundStrategy(): RoundStrategy = when (this) {
    "X" -> RoundStrategy.Lose
    "Y" -> RoundStrategy.Draw
    "Z" -> RoundStrategy.Win
    else -> throw Exception("Unsupported result")
}

enum class RoundStrategy {
    Lose,
    Win,
    Draw
}

fun RoundStrategy.computePlay(play: RPCPlay) = when (this) {
    RoundStrategy.Lose -> this lose play
    RoundStrategy.Win -> this win play
    RoundStrategy.Draw -> this draw play
}

infix fun RoundStrategy.lose(play: RPCPlay) = play.lose()
infix fun RoundStrategy.win(play: RPCPlay) = play.win()
infix fun RoundStrategy.draw(play: RPCPlay) = play.draw()

fun RPCPlay.win() = when (this) {
    RPCPlay.Rock -> RPCPlay.Paper
    RPCPlay.Paper -> RPCPlay.Scissors
    RPCPlay.Scissors -> RPCPlay.Rock
}
fun RPCPlay.lose() = when (this) {
    RPCPlay.Rock -> RPCPlay.Scissors
    RPCPlay.Paper -> RPCPlay.Rock
    RPCPlay.Scissors -> RPCPlay.Paper
}
fun RPCPlay.draw() = when (this) {
    RPCPlay.Rock -> RPCPlay.Rock
    RPCPlay.Paper -> RPCPlay.Paper
    RPCPlay.Scissors -> RPCPlay.Scissors
}

internal fun List<String>.toStrategicRounds() = map {
    val strategy = it.substringAfter(" ").roundStrategy()
    val elfPlay = it.substringBefore(" ").convertToPlay()

    Round(
        elf = elfPlay,
        player = strategy.computePlay(elfPlay)
    )
}

fun main() = solve { lines ->
    val rounds = lines.toStrategicRounds()

    rounds.sumOf { it.score }
}
