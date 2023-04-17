class Solution {
    fun addMinimum(word: String): Int {
        if (word.length <= 0) return 0
        
        var i = 0
        var next = 'a'
        var result = 0
        while(i < word.length) {
            if (word[i] == next) {
                next = (((next - 'a') + 1) % 3 + 'a'.toInt()).toChar()
                i++
            } else {
                next = (((next - 'a') + 1) % 3 + 'a'.toInt()).toChar()
                result++
            }
        }
        
        if (next == 'a') return result
        if (next == 'b') return result + 2
        return result + 1
    }
}