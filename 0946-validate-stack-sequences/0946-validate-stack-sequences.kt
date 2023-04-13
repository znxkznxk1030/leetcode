class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var j = 0
        for (i in pushed) {
            stack.push(i)
            
            while(!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop()
                j++
            }
        }
        
        return j == popped.size && stack.isEmpty()
    }
}