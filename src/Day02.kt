fun main() {
    val victories = mapOf("Rock" to "Scissors", "Paper" to "Rock", "Scissors" to "Paper")
    val losses = mapOf("Rock" to "Paper", "Paper" to "Scissors", "Scissors" to "Rock")
    val scores = mapOf("Rock" to 1, "Paper" to 2, "Scissors" to 3)

    fun part1(input: List<String>): Int {
        val playMap = mapOf("A" to "Rock", "B" to "Paper", "C" to "Scissors", "X" to "Rock", "Y" to "Paper", "Z" to "Scissors")
        var runningScore = 0
        for (play in input) {
            if (play.isBlank()) continue
            val splitMove = play.split(" ")
            val opponentMove = playMap[splitMove[0]]!!
            val yourMove = playMap[splitMove[1]]!!

            var playScore = 0
            playScore += scores[yourMove]!!

            val loser = victories[yourMove]
            if (yourMove == opponentMove) {
                playScore += 3
            } else if ( opponentMove == loser ) {
                playScore += 6
            }
            runningScore += playScore
        }
        return runningScore
    }

    fun part2(input: List<String>): Int {
        val playMap = mapOf("A" to "Rock", "B" to "Paper", "C" to "Scissors")
        var runningScore = 0
        for (play in input) {
            if (play.isBlank()) continue
            val splitMove = play.split(" ")
            val opponentMove = playMap[splitMove[0]]!!
            val desiredOutcome = splitMove[1]

            var playScore = 0

            if (desiredOutcome == "Z") {
                playScore += scores[losses[opponentMove]!!]!! + 6
            } else if (desiredOutcome == "Y") {
                playScore += scores[opponentMove]!! + 3
            } else {
                playScore += scores[victories[opponentMove]!!]!!
            }

//            println("${play} - ${playScore}")

            runningScore += playScore
        }
        return runningScore
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
