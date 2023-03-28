class Solution {
    val memo = HashMap<String, Boolean>()
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty()) return true
        if ( memo.containsKey(s) ) return memo.getOrDefault(s, false)
        
        memo.put(s, wordDict
            .filter{ s.substring(0, Math.min(s.length, it.length)).equals(it) }
            .any{ s.isEmpty() || wordBreak(s.substring(it.length), wordDict) })
        
        return memo.getOrDefault(s, false)
    }
}