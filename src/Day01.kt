fun main() {
    fun accumulateElves(input: List<String>): MutableList<Int> {
        val elves = mutableListOf<Int>()
        var currentElf = 0
        for (line in input) {
            if (line.isNotEmpty()) {
                currentElf += line.toInt()
            } else {
                elves.add(currentElf)
                currentElf = 0
            }
        }
        if (currentElf > 0) elves.add(currentElf)
        elves.sortDescending()
        return elves
    }

    fun part1(input: List<String>): Int {
        val elves = accumulateElves(input)
        return elves.get(0)
    }

    fun part2(input: List<String>): Int {
        val elves = accumulateElves(input)
        return elves.take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
