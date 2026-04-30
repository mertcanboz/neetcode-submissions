class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(sb, 0, 0, n);
        return result;
    }

    private void backtrack(StringBuilder sb, int open, int close, int n) {
        if (sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        }

        // add '(' if possible
        if (open < n) {
            sb.append('(');
            backtrack(sb, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }

        // add ')' only if valid
        if (close < open) {
            sb.append(')');
            backtrack(sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}