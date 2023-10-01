class Solution {
    fun reverseWords(s: String): String {
        return s.split(" ").map{ it -> it.reversed() }.joinToString(" ")
    }
}