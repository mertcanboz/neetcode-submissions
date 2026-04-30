class Solution {

    private static final int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (visited[i][j] || grid[i][j] == '0')
                    continue;
                bfs(grid, visited, i, j);
                count++;
            }
        }
        return count;
    }

    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            visited[point[0]][point[1]] = true;
            for (int[] d: directions) {
                int x = point[0] + d[0];
                int y = point[1] + d[1];
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
                    continue;
                if (visited[x][y])
                    continue;
                if (grid[x][y] == '0')
                    continue;
                queue.add(new int[]{x, y});
            }
        }
    }
}
