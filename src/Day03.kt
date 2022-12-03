fun main() {
    val items = ".abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    fun part1(input: List<String>): Int {
        var totalPriority = 0
        for (line in input) {
            val contents = line.toList()
            val compartment1 = contents.take(contents.size/2)
            val compartment2 = contents.takeLast(contents.size/2)
            val shared = compartment1.intersect(compartment2)
            totalPriority += items.indexOf(shared.first())
        }
        return totalPriority
    }

    fun part2(input: List<String>): Int {
        var totalPriority = 0
        val contentsIterator = input.iterator()
        while (contentsIterator.hasNext()) {
            val elf1 = contentsIterator.next().toSet()
            val elf2 = contentsIterator.next().toSet()
            val elf3 = contentsIterator.next().toSet()

            val s1 = elf1.intersect(elf2)
            val shared = s1.intersect(elf3)

            totalPriority += items.indexOf(shared.first())
        }
        return totalPriority
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    val testInputB = readInput("Day03_testb")
    check(part2(testInputB) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

