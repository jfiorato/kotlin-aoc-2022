import java.util.*

fun main() {
    fun part1(input: List<String>): String {
        val stacks: MutableMap<Int, Stack<String>> = mutableMapOf()
        for (line in input) {
            if (line.take(4) == "move") {
                val moveRegex = """move (\d*) from (\d*) to (\d*)""".toRegex()
                val moveMatchResult = moveRegex.find(line)!!
                repeat(moveMatchResult.groupValues[1].toInt()) {
                    val popped = stacks[moveMatchResult.groupValues[2].toInt()]?.pop()
                    stacks[moveMatchResult.groupValues[3].toInt()]?.push(popped)
                }
            } else {
                val stackRegex = """\[[A-Z]]""".toRegex()
                val stackMatchResults = stackRegex.findAll(line)
                stackMatchResults.forEach {
                    val stack = it.range.first/4
                    if (stacks[stack+1] == null) stacks[stack+1] = Stack<String>()
                    stacks[stack+1]?.insertElementAt(it.value[1].toString(), 0)
                }
            }
        }
        return stacks.toSortedMap().values.joinToString(separator = "") { it.last() }
    }

    fun part2(input: List<String>): String {
        val stacks: MutableMap<Int, Stack<String>> = mutableMapOf()
        for (line in input) {
            if (line.take(4) == "move") {
                val moveRegex = """move (\d*) from (\d*) to (\d*)""".toRegex()
                val moveMatchResult = moveRegex.find(line)!!
                val popped: Stack<String> = Stack<String>()
                repeat(moveMatchResult.groupValues[1].toInt()) {
                    popped.push(stacks[moveMatchResult.groupValues[2].toInt()]?.pop()!!)
                }
                while (popped.isNotEmpty()) {
                    stacks[moveMatchResult.groupValues[3].toInt()]?.push(popped.pop())
                }
            } else {
                val stackRegex = """\[[A-Z]]""".toRegex()
                val stackMatchResults = stackRegex.findAll(line)
                stackMatchResults.forEach {
                    val stack = it.range.first/4
                    if (stacks[stack+1] == null) stacks[stack+1] = Stack<String>()
                    stacks[stack+1]?.insertElementAt(it.value[1].toString(), 0)
                }
            }
        }
        return stacks.toSortedMap().values.joinToString(separator = "") { it.last() }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
