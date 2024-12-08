fun main() {
    val dirs = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1, 1 to 1, 1 to -1, -1 to 1, -1 to -1)
    val target = "XMAS"

    fun part1(map: List<String>): Int {
        var result = 0
        val jIndices = map[0].indices
        for (i in map.indices) {
            for (j in jIndices) {
                if (map[i][j] == target[0]) {

                    for (d in dirs) {
                        var (x, y) = i to j
                        var count = 1
                        for (ind in 1 until target.length) {
                            x += d.first
                            y += d.second
                            if (x in map.indices && y in jIndices && map[x][y] == target[ind]) {
                                //noop
                            } else {
                                count = 0
                                break
                            }
                        }
                        result += count
                    }

                }

            }
        }

        return result
    }

    fun part2(map: List<String>): Int {
        var result = 0
        for (i in 1 until map.size-1) {
            for (j in 1 until map[0].length-1) {
                if (map[i][j] == 'A') {
                    val d1 = listOf(map[i-1][j-1], map[i+1][j+1])
                    val d2 = listOf(map[i-1][j+1], map[i+1][j-1])

                    if ('M' in d1 && 'M' in d2 && 'S' in d1 && 'S' in d2) result++
                }
            }
        }
        return result
    }

    // Read the input from the `src/Day##.txt` file.
    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}