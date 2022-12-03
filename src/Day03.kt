import kotlin.math.*

fun main() {

    fun part1(input: List<String>): Int {
        var compartmentOne: CharSequence
        var compartmentTwo: CharSequence
        val commonItems: MutableList<Int> = mutableListOf()

        input.forEach { line ->
            val rucksack = line.trim()
            val middle = ceil(rucksack.length.toDouble() / 2).toInt()
            compartmentOne = rucksack.slice(0 until middle)
            compartmentTwo = rucksack.slice(middle until rucksack.length)

            run getItems@ {
                compartmentOne.forEach { item ->
                    if (compartmentTwo.contains(item)) {
                        when (item) {
                            item.uppercaseChar() -> commonItems.add(item.code - 38)
                            item.lowercaseChar() -> commonItems.add(item.code - 96)
                        }
                        return@getItems
                    }
                }
            }
        }
        return commonItems.sum()
    }

    fun part2(input: List<String>): Int {
        var groupOne: CharSequence
        var groupTwo: CharSequence
        var groupThree: CharSequence

        val badgesPriority: MutableList<Int> = mutableListOf()

        for (i in 0 until (input.size) step 3) {
            groupOne = input[i]
            groupTwo = input[i+1]
            groupThree = input[i+2]

            run getItems@ {
                groupOne.forEach { item ->
                    if (groupTwo.contains(item) && groupThree.contains(item)) {
                        when (item) {
                            item.uppercaseChar() -> badgesPriority.add(item.code - 38)
                            item.lowercaseChar() -> badgesPriority.add(item.code - 96)
                        }
                        return@getItems
                    }
                }
            }
        }

        return badgesPriority.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}