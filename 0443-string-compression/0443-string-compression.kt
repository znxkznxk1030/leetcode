class Solution {
    fun compress(chars: CharArray): Int {
        if (chars.size == 1) return 1
        
        var i: Int = 0
        var j: Int = 1
        var k: Int = -1
        
        while(j < chars.size) {
            if (chars[j] != chars[i]) {
                val size: Int = j - i
                
                chars[++k] = chars[i]
                if (size > 1) {
                    for (ch in size.toString()) {
                        chars[++k] = ch
                    }
                }
                
                i = j
            }
            
            j++;
        }
        
        val size: Int = j - i
        chars[++k] = chars[i]
        if (size > 1) {
            for (ch in size.toString()) {
                chars[++k] = ch
            }
        }
        
        return k + 1
    }
    
    fun log10 (size: Int) :Int {
        if (size == 1) return 0
        
        var ret = 0
        var num = size
        
        while(num > 0) {
            ret++
            num /= 10
        }
        
        return ret;
    }
}