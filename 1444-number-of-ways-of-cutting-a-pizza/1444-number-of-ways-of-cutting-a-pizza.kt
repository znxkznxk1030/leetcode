class Solution {
    fun ways(pizza: Array<String>, k: Int): Int {
        val mod = 1_000_000_007
        
        val height = pizza.size
        val width = pizza[0].length
        
        val dp = Array(k + 1){ Array(height + 1){ IntArray(width + 1){0} } }
        val apples = Array(height + 1){ IntArray(width + 1){0} }
        
        for (row in height - 1 downTo 0) {
            for (col in width - 1 downTo 0) {
                apples[row][col] = (if( pizza[row][col] == 'A') 1 else 0 ) + apples[row + 1][col] + apples[row][col + 1] - apples[row + 1][col + 1]
                dp[0][row][col] = if(apples[row][col] > 0) 1 else 0
            }
        }
        
        for (n in 1 until k) {
            for (row in 0 until height) {
                for (col in 0 until width) {
                    for (nextRow in row + 1 until height) {
                        if( apples[row][col] <= apples[nextRow][col] ) continue
                        dp[n][row][col] += dp[n - 1][nextRow][col]
                        dp[n][row][col] %= mod
                    }
                    
                    for (nextCol in col + 1 until width) {
                        if( apples[row][col] <= apples[row][nextCol] ) continue
                        dp[n][row][col] += dp[n - 1][row][nextCol]
                        dp[n][row][col] %= mod
                    }
                }
            }
        }
        
        return dp[k - 1][0][0]
    }
}