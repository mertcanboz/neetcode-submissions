class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxLength = 0;
        int i=0;
        for (int j=0; j<s.length(); j++) {
            if (!seen.contains(s.charAt(j))) {
                maxLength = Math.max(maxLength, j-i+1);
                seen.add(s.charAt(j));
            } else {
                while (i <= j && s.charAt(i++) != s.charAt(j)) {
                    seen.remove(s.charAt(i-1));
                }
            }
        }
        return maxLength;
    }
}
