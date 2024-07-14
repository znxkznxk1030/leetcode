class Solution {
    fun countOfAtoms(formula: String): String {
        val charr = formula.toCharArray()
        val n = charr.size
        val stack = Stack<Pair<String, Int>>()
        
        var i = 0
        while (i < n) {
            if (charr[i].isUpperCase()) {
                var atom = charr[i] + ""
                i += 1
                
                while(i < n && charr[i].isLowerCase()) {
                    atom += charr[i]
                    i += 1
                }
                
                var d = 0
                while(i < n && charr[i].isDigit()) {
                    d *= 10
                    d += charr[i].toInt() - '0'.toInt()
                    i += 1
                }
                
                d = maxOf(1, d)
                stack.push(Pair(atom, d))
            } else if (charr[i] == '(') {
                stack.push(Pair("(", 1))
                i += 1
            } else if (charr[i] == ')') {
                i += 1
                
                var temp = Stack<Pair<String, Int>>()
                
                while(stack.isNotEmpty()) {
                    val curr = stack.pop()
                    if (curr.first == "(") break
                    
                    temp.push(curr)
                }
                
                var d = 0
                while(i < n && charr[i].isDigit()) {
                    d *= 10
                    d += charr[i].toInt() - '0'.toInt()
                    i += 1
                }
                
                d = maxOf(1, d)
                
                while(temp.isNotEmpty()) {
                    val curr = temp.pop()
                    stack.push(Pair(curr.first, curr.second * d))
                }
            } else {
                
                i += 1
            }
        }
        
        println(stack)
        val freq = TreeMap<String, Int>()
        
        for (el in stack) {
            freq.put(el.first, freq.getOrDefault(el.first, 0) + el.second)
        }
        var result = ""
        
        for ((k, v) in freq) {
            result += "${k}"
            if (v > 1) {
                result += v.toString()
            }
        }
        
        return result
    }
}