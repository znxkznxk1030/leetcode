class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val adj = Array(n){ mutableListOf<Int>() }
        val rev = Array(n){ mutableListOf<Int>() }
        val indegree = IntArray(n)
        
        for (v in graph.indices) {
            for (u in graph[v]) {
                adj[u].add(v)
                rev[v].add(u)
                indegree[v]++
            }
        }
        
        val q = LinkedList<Int>()
        for (i in indegree.indices) {
            if (indegree[i] == 0) {
                q.offer(i)
            }            
        }
        
        val result = mutableListOf<Int>()
        while(!q.isEmpty()) {
            val node = q.poll()
            result.add(node)
            
            for (next in adj[node]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next)
                }
            }
        }
        
        result.sort()
        return result
    }
}