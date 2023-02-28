class Solution {
    fun minMaxDifference(num: Int): Int {
        val list = mutableListOf<Int>()
        var n = num
        while(n > 0) {
            list.add(n % 10)
            n /= 10
        }
        
        // println(list)
        
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        
        for (i in 0..9) {
            for (j in 0..9) {
                if (!list.contains(i)) continue;
                
                val tmp = list.map{it -> if (it == i) j else it}.reversed()
                
                var v = 0
                for(k in tmp) {
                    v = v * 10 + k
                }
                
                max = Math.max(max, v)
                min = Math.min(min,v)
            }
        }
        
        return max - min
    }
}