class Trie {
    var next: Array<Trie?>
    var isEnd = false
    
    constructor() {
        next = Array<Trie?>(26){null}
    }
}

class WordDictionary() {
    val root = Trie()

    fun addWord(word: String) {
        var curr: Trie? = root
        
        for (ch in word) {
            if (curr!!.next[ch - 'a'] == null) {
                curr.next[ch - 'a'] = Trie()
            }
            
            curr = curr.next[ch - 'a']
        }
        
        curr!!.isEnd = true
    }

    fun search(word: String): Boolean {
        return searchHelper(word, root)
    }
    
    fun searchHelper(word: String, curr: Trie?): Boolean {
        if (curr == null || (word.length == 0 && !curr.isEnd)) return false
        if (word.length == 0) return true
        
        val ch = word[0]
        if (ch == '.') {
            return (0..25).any{ searchHelper(word.substring(1), curr.next[it]) }
        } else {
            return if (curr.next[ch - 'a'] == null) false else searchHelper(word.substring(1), curr.next[ch - 'a'])
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */