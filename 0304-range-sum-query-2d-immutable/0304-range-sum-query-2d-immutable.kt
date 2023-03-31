class NumMatrix {
    val dp: Array<IntArray>
    
    constructor(matrix: Array<IntArray>) {
        dp = Array(matrix.size + 1){ IntArray(matrix[0].size + 1){0} }
        
        for (row in 1 .. matrix.size) {
            for (col in 1 .. matrix[0].size) {
                dp[row][col] = matrix[row - 1][col - 1] + dp[row - 1][col] + dp[row][col - 1]- dp[row - 1][col - 1]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1]
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */