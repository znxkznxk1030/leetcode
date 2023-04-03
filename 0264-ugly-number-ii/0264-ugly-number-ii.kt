class Solution {
    fun nthUglyNumber(n: Int): Int {
        val queue = PriorityQueue<Long>()
        val visit = HashSet<Long>()
        queue.offer(1L)
        var idx = 0
        
        while(!queue.isEmpty()) {
            val curr = queue.poll()
            if (++idx == n) {
                return curr.toInt()
            }
            
            
            for (k in listOf(2, 3, 5)) {
                if (visit.contains(curr * k)) continue
                visit.add(curr * k)
                queue.offer(curr * k)
            }
        }
        
        return -1
    }
}