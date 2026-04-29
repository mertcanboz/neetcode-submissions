class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int resultx = 0, resulty = 0;
        int maxLength = 0;
        for (int i=n-1; i>=0; i--) {
            for (int j=i; j<n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (maxLength < j - i + 1) {
                        maxLength = j - i + 1;
                        resultx = i;
                        resulty = j;
                    }
                }                
            }
        }
        return s.substring(resultx, resulty+1);
    }
}
