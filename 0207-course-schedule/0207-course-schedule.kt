class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj = Array(numCourses){ mutableListOf<Int>() }
        val indegree = IntArray(numCourses)
        var numSeen = 0
        
        for (edge in prerequisites) {
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
            numSeen++
            
            for (next in adj[node]) {
                indegree[next]--
                if (indegree[next] == 0) {
                    q.offer(next)
                }
            }
        }
        
        
        return numSeen >= numCourses
    }
}