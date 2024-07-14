class Solution {
    val MOD = 1_000_000_007
    fun numberOfPermutations(n: Int, requirements: Array<IntArray>): Int {
        val list = requirements.toList().sortedWith(compareBy({it[0]}, {it[1]}))
        list.forEach{ println("${it[0]} ${it[1]}")}
        
        val map = HashMap<Int, Int>()
        for (req in requirements) {
            map.put(req[0] + 1, req[1])
        }
        
        val dp = Array(n + 1){ IntArray( 401 ) }
        dp[0][0] = 1
        
        for (l in 1 .. n) {
            for (inv in 0 until 401) {
                for (pos in 0 until l) {
                    val pInv = inv - pos
                    if (pInv >= 0) {
                        dp[l][inv] += dp[l - 1][pInv]
                        dp[l][inv] %= MOD
                    }
                }
            }
            
            if (map.containsKey(l)) {
                val tInv = map[l]
                
                for (inv in 0 until 401) {
                    if (inv != tInv) {
                        dp[l][inv] = 0
                    }
                }
            }
        }
        
        
        
        var result = 0
        
        for(m in 0 until 401) {
            result += dp[n][m]
            result %= MOD
        }
        
        return result
    }
}