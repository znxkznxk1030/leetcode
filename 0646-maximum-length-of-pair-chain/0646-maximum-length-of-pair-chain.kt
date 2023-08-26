class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        val sorted = pairs.sortedWith(compareBy({ it[1] }))

        var result = 0
        val list = mutableListOf<Stack<IntArray>>()

        for (pair in sorted) {
            var flag = false
            for (st in list) {
                val peek = st.peek()

                if (peek[1] < pair[0]) {
                    st.push(pair)
                }
            }

            if (flag == false) {
                val st = Stack<IntArray>()
                st.push(pair)
                list.add(st)
            }
        }

        for (st in list) {
            result = maxOf(result, st.size)
        }

        return result
    }
}