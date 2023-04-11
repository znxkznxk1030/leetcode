class Solution {
    fun removeStars(s: String): String {
        val st = Stack<Char>()
        
        for (ch in s) {
            if (ch == '*') {
                st.pop()
            } else {
                st.push(ch)
            }
        }
        
        return st.joinToString("")
    }
}