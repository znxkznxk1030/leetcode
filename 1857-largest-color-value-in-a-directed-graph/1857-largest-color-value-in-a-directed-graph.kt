class Solution {
    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        val n = colors.length
        val adj = Array(n){ mutableListOf<Int>() }
        val indegree = IntArray(n){ 0 }
        
        for (edge in edges) {
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
        
        var nodeSeen = 0
        var result = 0
        val count = Array(n){ HashMap<Char, Int>() }
        
        while(!q.isEmpty()) {
            val curr = q.poll()
            val color = colors[curr]
            nodeSeen++
            
            val neighbors = adj[curr]
            val countOfColor = count[curr].getOrDefault(color, 0) + 1
            count[curr].put(color, countOfColor)
            
            for (neighbor in neighbors) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor)
                }
                
                for (ch in 'a'..'z') {
                    count[neighbor].put(ch, Math.max(count[neighbor].getOrDefault(ch, 0), count[curr].getOrDefault(ch, 0)))
                }
            }
            
            result = Math.max(countOfColor, result)
        }
        
        return if (nodeSeen < n) -1 else result
    }
}