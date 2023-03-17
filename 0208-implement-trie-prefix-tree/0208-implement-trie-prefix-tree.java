class TreeNode {
    char val;
    boolean eow;
    Map<Character, TreeNode> subs;

    TreeNode(char val) {
        this.val = val;
        this.subs = new HashMap<>();
        this.eow = false;
    }

    TreeNode() {
        this.subs = new HashMap<>();
        this.eow = false;
    }

    public TreeNode add(char ch) {
        TreeNode next = new TreeNode(ch);
        subs.putIfAbsent(ch, next);
        return next;
    }
}

class Trie {
    TreeNode root;

    public Trie() {
        root = new TreeNode();
    }
    
    public void insert(String word) {
        TreeNode cur = root;

        for (char ch: word.toCharArray()) {
            if(!cur.subs.containsKey(ch)) {
                cur = cur.add(ch);
            } else {
                cur = cur.subs.get(ch);
            }
        }

        cur.eow = true;
    }
    
    public boolean search(String word) {
        TreeNode cur = root;
        for (char ch: word.toCharArray()) {
            if(!cur.subs.containsKey(ch)) {
                return false;
            }

            cur = cur.subs.get(ch);
        }

        return cur.eow;
    }
    
    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for (char ch: prefix.toCharArray()) {
            if(!cur.subs.containsKey(ch)) {
                return false;
            }

            cur = cur.subs.get(ch);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */