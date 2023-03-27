class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int length = nums.length;
        int[] dp1 = new int[length];
        int[][] dp = new int[nums.length + 1][3];

        for (int i = 0; i < length; i++) {
            dp1[i] = -3999999;
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -3999999;
            }
        }

        dp1[0] = nums[0];
        dp[0][0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < length; i++) {
            dp1[i] = Math.max(dp1[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp1[i]);

            dp[i][0] = dp[i - 1][0] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]) + nums[i];
        }

        result = Math.max(result, dp[length - 1][2]);

        return result;
    }
}