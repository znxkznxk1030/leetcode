class Solution {
    fun canJump(nums: IntArray): Boolean {
        val visit = BooleanArray(nums.size){ false }
        
        val q = LinkedList<Int>()
        q.offer(0)
        
        while(!q.isEmpty()) {
            val curr = q.poll()
            
            for (next in curr..Math.min(curr + nums[curr], nums.size - 1))  {
                if (visit[next]) continue
                visit[next] = true
                
                q.offer(next)
            }
        }
        
        return visit[nums.size - 1]
    }
}
