class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= Math.max(0, i - 1); j--) {
                if (s.charAt(j) == '0') continue;
                int number = Integer.parseInt(s.substring(j, i + 1));

                if (number < 1 || number > 26) continue;

                if (j == 0) dp[i] += 1;
                else dp[i] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
