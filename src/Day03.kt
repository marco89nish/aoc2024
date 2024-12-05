fun main() {
    val mulRegex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)")
    val multiRegex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)")

    fun part1(memory: String): Int =
        mulRegex.findAll(memory)
            .sumOf { match -> match.groupValues[1].toInt() * match.groupValues[2].toInt() }

    fun part2(memory: String): Int {
        var enabled = true
        return multiRegex.findAll(memory)
            .filter {
                when (it.value) {
                    "do()" -> false.also { enabled = true }
                    "don't()" -> false.also { enabled = false }
                    else -> true
                }
            }
            .filter { enabled }
            .sumOf { match -> match.groupValues[1].toInt() * match.groupValues[2].toInt() }
    }

    // Read the input from the `src/Day##.txt` file.
    val input = readInput("Day03").joinToString()
    part1(input).println()
    part2(input).println()
}