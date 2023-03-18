class Node(v: String) {
    var prev: Node? = null
    var next: Node? = null
    var v = v
}

class BrowserHistory {
    var curr: Node?
    
    constructor(homepage: String) {
        curr = Node(homepage)
    }

    fun visit(url: String) {
        val tmp: Node? = Node(url)
        
        tmp!!.prev = curr
        curr!!.next = tmp
        
        curr = tmp
    }

    fun back(steps: Int): String {
        var k = steps
        while(k-- > 0 && curr!!.prev != null) curr = curr!!.prev
        return curr!!.v
    }

    fun forward(steps: Int): String {
        var k = steps
        while(k-- > 0 && curr!!.next != null) curr = curr!!.next
        return curr!!.v
    }

}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */