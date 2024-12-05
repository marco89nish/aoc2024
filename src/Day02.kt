
fun isSafe(report: List<Int>): Boolean {
    if (report.size < 2) return true

    val mult = if (report[1] - report[0] >= 0) 1 else -1

    return report.asSequence().zipWithNext().all { (first, second) ->
        (second - first) * mult in 1..3
    }
}

fun isSafeIfALevelIsRemoved(report: List<Int>): Boolean =
    report.indices.any { ind -> isSafe(report.take(ind) + report.takeLast(report.size - ind - 1)) }


fun main() {

    fun part1(reports: List<List<Int>>): Int = reports.count(::isSafe)

    fun part2(reports: List<List<Int>>): Int = reports.count { report -> isSafe(report) || isSafeIfALevelIsRemoved(report) }

    // Read the input from the `src/Day##.txt` file.
    val input = readInput("Day02")
    val reports = input.map(::parseLine)
    part1(reports).println()
    part2(reports).println()
}

private fun parseLine(line: String) = line.split(" ").map { it.toInt() }
