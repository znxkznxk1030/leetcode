class Solution {
    public boolean isHappy(int n) {
        Set<Integer> vi = new HashSet<>();

        while(!vi.contains(n)) {
            vi.add(n);
            int tmp = 0;
            while(n > 0) {
                tmp += (n % 10) * (n % 10);
                n /= 10;
            }

            n = tmp;
            if (n == 1) return true;
        }

        return false;
    }
}