class Solution {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val graph: MutableMap<Int, MutableList<Pair<Int, Int>>> = mutableMapOf()
        
        for (road in roads) {
            graph.computeIfAbsent(road[0]){ mutableListOf() }.add(Pair(road[1], road[2]))
            graph.computeIfAbsent(road[1]){ mutableListOf() }.add(Pair(road[0], road[2]))
        }
        
        var result = Int.MAX_VALUE
        
        val q = LinkedList<Int>()
        val visit = BooleanArray(n + 1){false}
        q.offer(1)
        while(!q.isEmpty()) {
            val curr = q.poll()
            if (visit[curr]) continue
            visit[curr] = true
            
            for(edge in graph.getOrDefault(curr, mutableListOf())) {
                if (visit[edge.first] == true) continue
                q.offer(edge.first)
                result = Math.min(edge.second, result)
            }
        }
        
        return result
    }
}