fun main() {
    fun getSet(input: String): Set<Int> {
        val (start, end) = input.split("-").map { it.toInt() }
        return IntRange(start, end).toSet()
    }

    fun part1(input: List<String>): Int {
        var counter = 0
        for (line in input) {
            val (assignment1, assignment2) = line.split(",")
            val assignment1Set = getSet(assignment1)
            val assignment2Set = getSet(assignment2)

            if ((assignment1Set - assignment2Set).isEmpty()) {
                counter += 1
            } else if ((assignment2Set - assignment1Set).isEmpty()) {
                counter += 1
            }
        }
        return counter
    }

    fun part2(input: List<String>): Int {
        var counter = 0
        for (line in input) {
            val (assignment1, assignment2) = line.split(",")
            val assignment1Set = getSet(assignment1)
            val assignment2Set = getSet(assignment2)

            if ((assignment1Set.intersect(assignment2Set)).isNotEmpty()) {
                counter += 1
            }
        }
        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
