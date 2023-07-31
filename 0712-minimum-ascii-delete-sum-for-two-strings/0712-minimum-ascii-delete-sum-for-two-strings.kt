class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val n = s1.length
        val m = s2.length
        
        val dp = Array(n + 1){ IntArray(m + 1){ 0 } }
        val memo = Array(n + 1){ Array(m + 1){ mutableListOf<Char>() }}
        
        var common = mutableListOf<Char>()
        for (i in 1 .. n) {
            for (j in 1 .. m) {
                if (s1[i - 1] == s2[j - 1])  {
                    memo[i][j] = memo[i - 1][j - 1].toMutableList()
                    memo[i][j].add(s1[i - 1])
                } else {
                    if (dp[i][j - 1] > dp[i - 1][j]) {
                        memo[i][j] = memo[i][j - 1]
                    } else {
                        memo[i][j] = memo[i - 1][j]
                    }
                }
                
                dp[i][j] = getSum(memo[i][j])
                if (getSum(common) <= getSum(memo[i][j])) {
                    common = memo[i][j].toMutableList()
                }
            }
        }
        println("${common}")
        
        var result = getSum(s1.toMutableList()) + getSum(s2.toMutableList()) - getSum(common) - getSum(common)
        return result
    }
    
    fun getSum(list: MutableList<Char>): Int{
        var ret = 0
        
        for (ch in list) {
            ret += ch.toInt()
        }
        
        return ret
    }
}