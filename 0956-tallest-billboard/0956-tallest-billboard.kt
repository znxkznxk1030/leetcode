class Solution {
    fun tallestBillboard(rods: IntArray): Int {
        val n = rods.size
        val sum = rods.sum()!!
        val memo = HashMap<Pair<Int, Int>, Int>()
        
        fun dfs(i: Int, diff: Int): Int {
            if(i == n) return if(diff == 0) 0 else Int.MIN_VALUE
            if(diff > sum/2) return Int.MIN_VALUE
            
            if (memo.containsKey(Pair(i, diff))) return memo.getOrDefault(Pair(i, diff), 0)
            
            var result = dfs(i + 1, diff)
            result = Math.max(result, dfs(i + 1, diff + rods[i]) + rods[i])
            result = Math.max(result, dfs(i + 1, Math.abs(diff - rods[i])) + (if(diff >= rods[i]) 0 else (rods[i] - diff)))
            
            memo.put(Pair(i, diff), result)
            
            return result
        }
        
        return dfs(0, 0)
    }
}