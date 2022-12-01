fun main() {

    fun getInventories(input: List<String>): MutableList<Int> {
        val calories: MutableList<Int> = mutableListOf()
        var currentInventory = 0

        input.forEach { line ->
            if (line == "") {
                calories.add(currentInventory)
                currentInventory = 0
            } else {
                currentInventory += line.toInt()
            }
        }

        if (currentInventory != 0) {
            calories.add(currentInventory)
        }

        return calories
    }

    fun part1(input: List<String>): Int {
        val calories = getInventories(input)
        return calories.maxOrNull() ?: 0
    }

    fun part2(input: List<String>): Int {
        val calories = getInventories(input)
        calories.sortDescending()
        return calories[0] + calories[1] + calories[2]
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

     val input = readInput("Day01")
     println(part1(input))
     println(part2(input))
}
