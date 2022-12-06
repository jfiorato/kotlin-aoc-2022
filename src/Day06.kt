fun main() {
    fun part1(input: List<String>): Array<Int> {
        var results: Array<Int> = arrayOf()
        input.forEach charLoop@{
            val marker: ArrayList<Char> = arrayListOf()
            it.forEachIndexed { idx, char ->
                if (marker.size == 4) {
                    marker.removeAt(0)
                    marker += char
                    if (marker.distinct().size == 4) {
                        results += (idx + 1)
                        return@charLoop
                    }
                } else {
                    marker += char
                }
            }
        }
        return results
    }

    fun part2(input: List<String>): Array<Int> {
        var results: Array<Int> = arrayOf()
        input.forEach charLoop@{
            val marker: ArrayList<Char> = arrayListOf()
            it.forEachIndexed { idx, char ->
                if (marker.size == 14) {
                    marker.removeAt(0)
                    marker += char
                    if (marker.distinct().size == 14) {
                        results += (idx + 1)
                        return@charLoop
                    }
                } else {
                    marker += char
                }
            }
        }
        return results
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput).contentEquals(arrayOf(7, 5, 6, 10, 11)))
    check(part2(testInput).contentEquals(arrayOf(19, 23, 23, 29, 26)))

    val input = readInput("Day06")
    println(part1(input).joinToString(separator = ","))
    println(part2(input).joinToString(separator = ","))
}
