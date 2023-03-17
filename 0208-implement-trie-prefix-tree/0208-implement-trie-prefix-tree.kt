class TrieNode {
    val links: Array<TrieNode?>
    var isEnd: Boolean = false
    
    constructor() {
        links = Array<TrieNode?>(26){ null }
    }
    
    fun has(ch: Char): Boolean {
        return links[ch - 'a'] != null
    }
    
    fun get(ch: Char): TrieNode? {
        return links[ch - 'a']
    }
    
    fun put(ch: Char, node: TrieNode) {
        links[ch - 'a'] = node
    }
}

class Trie() {
    
    val root = TrieNode();

    fun insert(word: String) {
        var curr: TrieNode? = root
        
        for(ch in word) {
            if (!curr!!.has(ch)) {
                curr.put(ch, TrieNode())
            }
            
            curr = curr.get(ch)
        }
        
        curr!!.isEnd = true
    }

    fun search(word: String): Boolean {
        var curr: TrieNode? = root
        
        for (ch in word) {
            if (!curr!!.has(ch)) return false
            curr = curr!!.get(ch)
        }
        
        return curr!!.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var curr: TrieNode? = root
        
        for (ch in prefix) {
            if (!curr!!.has(ch)) return false
            curr = curr!!.get(ch)
        }
        
        return true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */