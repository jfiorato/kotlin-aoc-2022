fun main() {
    fun part1(input: List<String>): Int {
        var total = 0
        for (play in input) {
            val (col1, col2) = play.split(" ")
            val opponent = "ABC".indexOf(col1)
            val you = "XYZ".indexOf(col2)

            total += you + 1

            when ((you - opponent).mod(3)) {
                1 -> total += 6
                0 -> total += 3
            }
        }
        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0
        for (play in input) {
            val (col1, col2) = play.split(" ")
            val opponent = "ABC".indexOf(col1)

            when (col2) {
                "X" -> {
                    total += (opponent - 1).mod(3) + 1
                }
                "Y" -> {
                    total += 3
                    total += opponent + 1
                }
                "Z" -> {
                    total += 6
                    total += (opponent + 1).mod(3) + 1
                }
            }
        }
        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
