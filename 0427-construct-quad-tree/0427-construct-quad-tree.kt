/**
 * Definition for a QuadTree node.
 * class Node(var `val`: Boolean, var isLeaf: Boolean) {
 *     var topLeft: Node? = null
 *     var topRight: Node? = null
 *     var bottomLeft: Node? = null
 *     var bottomRight: Node? = null
 * }
 */

class Solution {
    fun construct(grid: Array<IntArray>): Node? {
        return constructInRange(grid, 0, 0, grid[0].size - 1, grid.size - 1)
    }

    fun constructInRange(grid: Array<IntArray>, startX: Int, startY: Int, endX: Int, endY: Int): Node? {
        // println("==")
        // for (y in startY..endY) {
        //     for (x in startX..endX) {
        //         print("${grid[y][x]} ")
        //     }
        //     println()
        // }
        // println("==")

        if (isMono(grid, startX, startY, endX, endY)) {
            return Node(grid[startY][startX] == 1, true)
        }

        val result = Node(grid[startY][startX] == 1, false)

        val midX = (endX - startX) / 2 + startX
        val midY = (endY - startY) / 2 + startY

        result.topLeft = constructInRange(grid, startX, startY, midX, midY)
        result.topRight = constructInRange(grid, midX + 1, startY, endX, midY)
        result.bottomLeft = constructInRange(grid, startX, midY + 1, midX, endY)
        result.bottomRight = constructInRange(grid, midX + 1, midY + 1, endX, endY)

        return result
    }

    fun isMono(grid: Array<IntArray>, startX: Int, startY: Int, endX: Int, endY: Int): Boolean {

        val v = grid[startY][startX]

        for (y in startY..endY) {
            for (x in startX..endX) {
                if (grid[y][x] != v) return false
            }
        }

        return true
    }
}