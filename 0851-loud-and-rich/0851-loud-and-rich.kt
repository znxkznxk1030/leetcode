class Solution {
    fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
        val n = quiet.size
        val result = IntArray(n){ Int.MAX_VALUE }
        
        val adj = Array(n){ mutableListOf<Int>() }
        val indegree = IntArray(n){ 0 }
        
        for (edge in richer) {
            val u = edge[0]
            val v = edge[1]
            
            adj[u].add(v)
            indegree[v]++
        }
        
        val q = LinkedList<Int>()
        for (i in indegree.indices) {
            if (indegree[i] == 0) {
                q.offer(i)
            }
        }
        
        while (!q.isEmpty()) {
            val node = q.poll()
            val quietness = quiet[node]
            result[node] = Math.min(result[node], quietness)
            
            for (next in adj[node]) {
                if (--indegree[next] == 0 ) {
                    q.offer(next)
                }
                result[next] = Math.min(result[next], result[node])
            }
        }
        
        val qmap = HashMap<Int, Int>()
        
        for (i in quiet.indices) {
            qmap.put(quiet[i], i)
        }
        
        for (i in result.indices){
            result[i] = qmap.get(result[i])!!
        }
        
        return result
    }
}