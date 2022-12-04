fun main() {
    fun List<Int>.swap(index1: Int, index2: Int): MutableList<Int> {
        val copy = this.toMutableList()
        val tmp = copy[index1]
        copy[index1] = copy[index2]
        copy[index2] = tmp
        return copy
    }

    fun part1(input: List<String>): Int {
        var contains = 0

        input.forEach { line ->
            val num = line
                .trim()
                .split(',', '-')
                .map { it.toInt() }

            val acdb = num
                .swap(1,2)
                .swap(2,3)

            val cabd = num
                .swap(0,2)
                .swap(1,2)

            if (num.sorted() == acdb || num.sorted() == cabd) contains++
        }
        return contains
    }

    fun part2(input: List<String>): Int {
        var overlaps = 0

        input.forEach { line ->
            val num = line
                .trim()
                .split(',', '-')
                .map { it.toInt() }

            if (kotlin.math.min(num[3], num[1]) - kotlin.math.max(num[0], num[2]) >= 0) overlaps++
        }
        return overlaps
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}