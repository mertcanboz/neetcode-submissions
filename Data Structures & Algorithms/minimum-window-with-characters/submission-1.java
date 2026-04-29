class Solution {
    public String minWindow(String s, String t) {
        int[] needed = new int[52];
        int[] window = new int[52];
        int minLength = Integer.MAX_VALUE;
        String result = "";

        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            if (Character.isUpperCase(c)) {
                needed[26+c-'A']++;
            } else {
                needed[c - 'a']++;
            }
        }

        int i=0, j=0;

        while (j < s.length()) {
            int jIndex = Character.isUpperCase(s.charAt(j)) ? 26 + s.charAt(j) - 'A' : s.charAt(j) - 'a';
            window[jIndex]++;
            int iIndex = Character.isUpperCase(s.charAt(i)) ? 26 + s.charAt(i) - 'A' : s.charAt(i) - 'a';
            while (i <= j && window[iIndex] > needed[iIndex]) {
                window[iIndex]--;
                i++;
                if (i < s.length()) iIndex = Character.isUpperCase(s.charAt(i)) ? 26 + s.charAt(i) - 'A' : s.charAt(i) - 'a';
            }
            if (j >= i && includes(window, needed)) {
                if (minLength > j-i+1) {
                    minLength = j-i+1;
                    result = s.substring(i,j+1);
                }
            }
            j++;
        }

        return result;
    }

    private boolean includes(int[] array, int[] other) {
        for (int i=0; i<array.length; i++) {
            if (array[i] < other[i]) return false;
        }
        return true;
    }
}
