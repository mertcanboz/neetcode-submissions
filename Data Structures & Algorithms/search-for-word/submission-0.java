class Solution {
    private static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,1},{0,-1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited,
                        int i, int j, int idx) {

        // ✅ base case: all characters matched
        if (idx == word.length()) return true;

        // ❌ invalid conditions
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;

        if (visited[i][j] || board[i][j] != word.charAt(idx))
            return false;

        // ✅ choose
        visited[i][j] = true;

        // ✅ explore
        for (int[] d : DIRECTIONS) {
            if (dfs(board, word, visited, i + d[0], j + d[1], idx + 1)) {
                return true;
            }
        }

        // ✅ backtrack (CRITICAL)
        visited[i][j] = false;

        return false;
    }
}