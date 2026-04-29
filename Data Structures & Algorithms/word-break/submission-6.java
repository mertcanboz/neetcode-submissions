class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer,Boolean> memo = new HashMap<>();
        memo.put(s.length(), true);
        return backtrack(memo, s, wordDict, 0);
    }

    private boolean backtrack(Map<Integer,Boolean> memo, String s, List<String> words, int i) {
        if (memo.containsKey(i)) return memo.get(i);
        for (String word: words) {
            if (i+word.length() > s.length()) continue;
            if (word.equals(s.substring(i, i+word.length()))) {
                if (backtrack(memo, s, words, i+word.length())) {
                    memo.put(i, true);
                    return true;
                }
            }
        }
        memo.put(i, false);
        return false;
    }
}
