class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[][] dp = new int[n][2];
        int result = 0;
        dp[0][0] = nums[0];
        for (int i=1; i<n-1; i++) {
            dp[i][0] = dp[i-1][1] + nums[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        result = Math.max(dp[n-2][0], dp[n-2][1]);

        dp = new int[n][2];
        dp[1][0] = nums[1];
        for (int i=2; i<n; i++) {
            dp[i][0] = dp[i-1][1] + nums[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        result = Math.max(result, Math.max(dp[n-1][0], dp[n-1][1]));
        return result;
    }
}
