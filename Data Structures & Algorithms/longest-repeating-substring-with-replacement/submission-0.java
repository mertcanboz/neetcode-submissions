class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int majorityCount = 0;
        int i = 0, j = 0;
        int[] count = new int[26];
        while (j < s.length()) {
            count[s.charAt(j)-'A']++;
            majorityCount = Math.max(majorityCount, count[s.charAt(j)-'A']);
            while ((j-i+1) - majorityCount > k) {
                count[s.charAt(i)-'A']--;
                majorityCount = Math.max(majorityCount, count[s.charAt(i)-'A']);
                i++;
            }
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }
        return maxLength;
    }
}
