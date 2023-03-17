class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        
        Arrays.sort(candidates)
        dfs(candidates, 0, target, mutableListOf<Int>(), result)
        
        return result.distinct()
    }
    
    fun dfs(candidates: IntArray, idx: Int, target: Int, list: MutableList<Int>, result: MutableList<MutableList<Int>>) {
        if (target == 0) {
            result.add(list)
            return
        }
        
        if (target < 0) {
            return
        }
        
        for (i in idx until candidates.size) {
            if (i > idx && candidates[idx] == candidates[i]) continue;
            
            list.add(candidates[i])
            dfs(candidates, i + 1, target - candidates[i], list.toMutableList(), result)
            list.remove(list.last())
        }
    }
}