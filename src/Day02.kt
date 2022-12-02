fun main() {
    var playerScore = 0

    val playerMoveMap: Map<Char, Int> = mapOf(
        'X' to 1,
        'Y' to 2,
        'Z' to 3
    )
    val botMoveMap: Map<Char, Int> = mapOf(
        'A' to 1,
        'B' to 2,
        'C' to 3
    )

    fun playerWin() {
        playerScore += 6
    }

    // compare player's move (1,2,3) to opponent's move (1,2,3)
    // Win -> +6 pts 
    // Draw -> +3 pts
    // Lose -> +0pts
    fun compareMoves(playerMove: Int, botMove: Int) {
        // add points from the move:
        // (Rock -> 1 pt, Paper -> 2pts, Scissors -> 3pts)
        playerScore += playerMove

        // check for wins
        when (playerMove) {
            1 -> if (botMove == 3) playerWin()
            2 -> if (botMove == 1) playerWin()
            3 -> if (botMove == 2) playerWin()
        }

        // check for draw
        if (playerMove == botMove) playerScore += 3
    }

    fun part1(input: List<String>): Int {
        playerScore = 0

        input.forEach { line ->
            val playerMove: Int? = playerMoveMap[line[2]]
            val botMove: Int? = botMoveMap[line[0]]

            if (playerMove != null && botMove != null) {
                // Compare moves with opponent to update the score
                compareMoves(playerMove, botMove)
            }
        }
        return playerScore
    }

    fun part2(input: List<String>): Int {
        playerScore = 0

        input.forEach { line -> 
            var playerMove: Int? = playerMoveMap[line[2]]
            val botMove: Int? = botMoveMap[line[0]]
            val playerAction = line[2]

            if (playerMove != null && botMove != null) {
                // Change player's move (1,2,3) depending on the type of action given
                // X -> Lose
                // Y -> Draw
                // Z -> Win
                when (playerAction) {
                    'X' -> {
                        playerMove = botMove - 1
                        if (playerMove <= 0) playerMove = 3
                    }
                    'Y' -> playerMove = botMove
                    'Z' -> {
                        playerMove = botMove + 1
                        if (playerMove >= 4) playerMove = 1
                    }
                }
                // Compare moves with opponent to update the score
                compareMoves(playerMove, botMove)
            }
        }
        return playerScore
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}