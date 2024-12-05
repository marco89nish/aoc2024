fun main() {
    val mulRegex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)")
    val multiRegex = Regex("(mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\))")

    fun part1(memory: String): Int =
        mulRegex.findAll(memory)
            .map { matchResult -> matchResult.value }
            .map { exp -> exp.substring(4, exp.length - 1) }
            .map { csv -> csv.split(',') }
            .sumOf { vals -> vals[0].toInt() * vals[1].toInt() }

    fun part2(memory: String): Int {
        var enabled = true
        return multiRegex.findAll(memory)
            .map { matchResult -> matchResult.value }
            .filter {
                when (it) {
                    "do()" -> false.also { enabled = true }
                    "don't()" -> false.also { enabled = false }
                    else -> true
                }
            }
            .filter { enabled }
            .map { exp -> exp.substring(4, exp.length - 1) }
            .map { csv -> csv.split(',') }
            .sumOf { vals -> vals[0].toInt() * vals[1].toInt() }
    }

    // Read the input from the `src/Day##.txt` file.
    val input = readInput("Day03").joinToString()
    part1(input).println()
    part2(input).println()
}