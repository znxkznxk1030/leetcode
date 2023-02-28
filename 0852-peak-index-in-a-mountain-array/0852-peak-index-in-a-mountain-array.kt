class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var left: Int = 0
        var right: Int = arr.size - 1

        while (left < right) {
            val mid = left + (right - left) / 2

            if ( (mid == 0 || arr[mid] > arr[mid - 1]) 
                && (mid == arr.size - 1 || arr[mid] > arr[mid + 1])) {
                    return mid
            }

            if ( arr[mid + 1] < arr[mid]) {
                right = mid
            } else if ( arr[mid - 1] < arr[mid]) {
                left = mid
            }
        }

        return left
    }
}