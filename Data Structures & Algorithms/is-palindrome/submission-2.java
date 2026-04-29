class Solution {
    public boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;
        while (l<r) {
            while (l<r && !Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l))) {
                l++;
            }
            while (l<r && !Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))) return false;
        }
        return true;
    }
}
