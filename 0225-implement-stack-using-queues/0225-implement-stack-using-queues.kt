class MyStack() {
    var q1 = LinkedList<Int>()
    var q2 = LinkedList<Int>()
    
    fun push(x: Int) {
        q1.offer(x)
    }

    fun pop(): Int {
        val n = q1.size
        
        for (i in 0 until n - 1) {
            q2.offer(q1.poll())
        }
        
        val ret = q1.poll()
        q1 = q2
        q2 = LinkedList<Int>()
        
        return ret
    }

    fun top(): Int {
        val ret = pop()
        q1.offer(ret)
        return ret
    }

    fun empty(): Boolean {
        return q1.isEmpty()
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */