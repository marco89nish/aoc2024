import kotlin.math.absoluteValue

fun main() {
    fun part1(list1: List<Int>, list2: List<Int>): Int {
        return (list1.sorted() zip list2.sorted())
                .sumOf { (first, second) -> (first - second).absoluteValue }
    }

    fun part2(list1: List<Int>, list2: List<Int>): Int {
        val counts = list2.groupingBy { it }.eachCount()
        return list1.sumOf { el -> el * (counts[el] ?: 0) }
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    val pairs = input.map(::parseLine)
    val (list1, list2) = pairs.unzip()
    part1(list1, list2).println()
    part2(list1, list2).println()
}

private fun parseLine(line: String) = line.split("   ").map { it.toInt() }.let { it[0] to it[1] }
