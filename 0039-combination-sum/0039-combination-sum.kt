class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        
        dfs(candidates, target, mutableListOf<Int>(), result)
        
        return result.distinct()
    }
    
    fun dfs(candidates: IntArray, target: Int, list: MutableList<Int>, result: MutableList<MutableList<Int>>) {
        if (target < 0) {
            return
        }
        
        if (target == 0) {
            list.sort()
            result.add(list)
            return
        }
        
        for (c in candidates) {
            list.add(c)
            dfs(candidates, target - c, list.toMutableList(), result)
            list.remove(list.last())
        }
    }
}