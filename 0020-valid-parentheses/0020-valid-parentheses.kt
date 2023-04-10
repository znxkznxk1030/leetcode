class Solution {
    fun isValid(s: String): Boolean {
        val st = Stack<Char>()
        
        for (ch in s) {
            if (listOf('(', '{', '[').any{it == ch}) {
                st.push(ch)
                continue
            } 
            
            when(ch) {
                ')' -> if (st.isEmpty() || st.peek() != '(') return false else st.pop()
                '}' -> if (st.isEmpty() || st.peek() != '{') return false else st.pop()
                ']' -> if (st.isEmpty() || st.peek() != '[') return false else st.pop()
            }
        }
        
        return st.isEmpty()
    }
}