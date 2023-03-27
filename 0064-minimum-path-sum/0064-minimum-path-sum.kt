class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val dp = Array(grid.size){ IntArray(grid[0].size){ 0 } }
        
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j]
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j]
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j]
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
                }
            }
        }
        
        return dp[grid.size - 1][grid[0].size - 1]
    }
}