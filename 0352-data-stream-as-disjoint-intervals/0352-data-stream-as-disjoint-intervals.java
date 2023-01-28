class SummaryRanges {

    List<int[]> data;
    public SummaryRanges() {
        data = new LinkedList<>();
    }
    
    public void addNum(int value) {
        if (data.isEmpty()) {
            int[] num = {value, value};
            data.add(num);
            return;
        }
        
        int low = 0, high = data.size();
        int mid = low + (high - low) / 2;
        while (low < high) {
            mid = low + (high - low) / 2;
            int[] curr = data.get(mid);
            
            if (curr[0] > value) {
                high = mid ;
            } else if (curr[0] <= value) {
                low = mid + 1;
            }
        }
        
        System.out.println(low);
        int[] num = {value, value};
        data.add(low, num);
        int index = low;
        
        int[] prev = index >= 1?data.get(index - 1):null;
        int[] post = data.size() > index + 1?data.get(index + 1):null;
        
        while((prev != null && prev[1] + 1 >= num[0]) || (post != null && post[0] <= num[1] + 1)) {
            if (prev != null && prev[1] + 1 >= num[0]) {
                prev[1] = Math.max(num[1], prev[1]);
                data.remove(index);
                num = prev;
                index = index - 1;
                
                System.out.println("prev : " + prev[0] + " - " + prev[1]);
            }
            
            if (post != null && post[0] <= num[1] + 1) {
                post[0] = Math.min(num[0], post[0]);
                data.remove(index);
                num = post;
                
                System.out.println("post : " + post[0] + " - " + post[1]);
            }
            
            prev = index >= 1?data.get(index - 1):null;
            post = data.size() > index + 1?data.get(index + 1):null;
        }
    }
    
    public int[][] getIntervals() {
        int[][] result = new int[data.size()][2];
        
        for (int i = 0 ; i < data.size(); i++) {
            result[i] = data.get(i);
        }
        
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */