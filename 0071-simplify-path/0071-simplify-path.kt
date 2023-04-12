class Solution {
    fun simplifyPath(path: String): String {
        var tokens = path.replace("//", "/").split("/")
        var stack = Stack<String>()
        
        for (token in tokens) {
            val trim = token.trim()
            if (trim.equals(".") || trim.isEmpty()) {
            } else if (trim.equals("..")) {
                if (!stack.isEmpty()) stack.pop()
            } else {
                stack.push(trim)
            }
        }
        
        while (!stack.isEmpty() && stack.peek().isEmpty()) {
            stack.pop()
        }
        
        var result = stack.joinToString("/").replace("//", "/")
        if (result.isEmpty() || result[0] != '/') {
            result = "/" + result
        }
        return result
    }
}