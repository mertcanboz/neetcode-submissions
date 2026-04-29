class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int i=0, j=0;
        int[] counts = new int[256];
        while (j<s.length()) {
            counts[s.charAt(j)]++;
            while (i<j && counts[s.charAt(j)] > 1) {
                counts[s.charAt(i++)]--;
            }
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }
        return maxLength;
    }
}
