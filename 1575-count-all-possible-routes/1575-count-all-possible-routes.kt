class Solution {
    val mod = 1_000_000_007
    
    fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {
        val memo = HashMap<Pair<Int, Int>, Int>()
        val n = locations.size
        
        fun helper(i: Int, left: Int): Int {
            val key = Pair(i, left)
            if (memo.containsKey(key)) return memo.getOrDefault(key, 0)
            var result = if(i == finish) 1 else 0
            
            for (next in 0 until n) {
                if (next == i) continue
                
                val diff = left - Math.abs(locations[next] - locations[i])
                if (diff < 0) continue
                
                result += helper(next, diff)
                result %= mod
            }
            
            memo.put(key, result)
            return result
        }
        
        return helper(start, fuel)
    }
}