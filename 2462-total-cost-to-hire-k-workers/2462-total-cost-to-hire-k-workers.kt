class Solution {
    var lambda = {a:Int,b:Int-> when{
        a<b -> 1
        a>b -> -1
        else -> 0
    }}
    
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        val pq = PriorityQueue(Comparator<Pair<Int,Int>>{a,b ->
            when{
                a.first != b.first -> lambda(b.first,a.first)
                else -> lambda(b.second, a.second)
        }})
        
        val n = costs.size
        
        var left = candidates - 1
        var right = n - candidates
        
        if (left < right) {
            for (i in 0 .. left) {
                pq.offer(Pair(costs[i], i))
            }
            
            for (i in right until n) {
                pq.offer(Pair(costs[i], i))
            }
        } else {
            for (i in 0 until n) {
                pq.offer(Pair(costs[i], i))
            }
        }
        
        var result = 0L
        for (i in 0 until k) {
            if(pq.isEmpty()) break;
            val curr = pq.poll()
            result += curr.first.toLong()
            
            val pos = curr.second
            if (left + 1 < right) {
                if (pos <= left) {
                    left++
                    pq.offer(Pair(costs[left], left))
                } else {
                    right--
                    pq.offer(Pair(costs[right], right))
                }
            }
        }
        
        return result
    }
}