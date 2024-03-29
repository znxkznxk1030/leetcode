class Solution {
    val memo = HashMap<String, Boolean>()
    
    fun isScramble(s1: String, s2: String): Boolean {
        if (s1.equals(s2)) return true
        if (!isAnagram(s1, s2)) return false
        
        memo["${s1} - ${s2}"]?.let{ return it }
        
        val n = s1.length
        for (i in 1 until s1.length) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i  )) && isScramble(s1.substring(i, n), s2.substring(i, n  )))
             || (isScramble(s1.substring(0, i), s2.substring(n-i, n)) && isScramble(s1.substring(i, n), s2.substring(0, n-i)))) {
                memo["${s1} - ${s2}"] = true
                return true
            }
        }
        
        memo["${s1} - ${s2}"] = false
        return false
    }
    
    
    fun isAnagram(s1: String, s2: String): Boolean {
        val visit = HashMap<Char, Int>()
        
        s1.forEach{ visit.put(it, visit.getOrDefault(it, 0) + 1)}
        s2.forEach{ visit.put(it, visit.getOrDefault(it, 0) - 1)}
        
        return visit.values.toList().all{ it == 0 }
    }
}