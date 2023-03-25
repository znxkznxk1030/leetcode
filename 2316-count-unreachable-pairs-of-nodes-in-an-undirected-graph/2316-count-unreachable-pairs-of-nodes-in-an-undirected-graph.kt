class UnionFind {
    val ids: IntArray
    val ranks: IntArray
    
    constructor(n: Int) {
        ids = IntArray(n){ it }
        ranks = IntArray(n){ 0 }
    }
    
    fun find(x: Int): Int {
        return if(x == ids[x]) x else find(ids[x])
    }
    
    fun union(x: Int, y: Int): Unit {
        val fx = find(x)
        val fy = find(y)
        
        if (fx == fy) return
        
        if (ranks[fx] < ranks[fy]) {
            ids[fx] = fy
            ranks[fx] += ranks[fy]
        } else {
            ids[fy] = fx
            ranks[fy] += ranks[fx]
        }
    }
}

class Solution {
    fun countPairs(n: Int, edges: Array<IntArray>): Long {
        val uf = UnionFind(n)
        
        for(edge in edges) {
            uf.union(edge[0], edge[1])
        }
        
        val groups: MutableMap<Int, Long> = mutableMapOf()
        for (i in 0 until n) {
            val fi = uf.find(i)
            groups.put(fi, groups.getOrDefault(fi, 0L) + 1L)
        }
        
        var result = 0L
        for ((k, v) in groups) {
            result += (v * (n - v))
        }
        
        return result / 2
    }
}


















