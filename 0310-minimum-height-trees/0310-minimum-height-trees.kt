class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val adj = Array(n){ mutableListOf<Int>() }
        val indegree = IntArray(n)
        
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            
            adj[u].add(v)
            adj[v].add(u)
            
            indegree[u]++
            indegree[v]++
        }
        
        var q = LinkedList<Int>()
        for (i in indegree.indices) {
            if (indegree[i] == 1) {
                q.offer(i)
            }
        }
        
        while(!q.isEmpty()) {
            val nq = LinkedList<Int>()
            val result = mutableListOf<Int>()
            while(!q.isEmpty()) {
                val node = q.poll()
                result.add(node)
                
                for (next in adj[node]) {
                    indegree[next]--
                    if(indegree[next] == 1) {
                        nq.offer(next)
                    }
                }
            }
            
            if (nq.isEmpty()) {
                return result
            }
            q = nq
        }
        
        return listOf(0)
    }
}