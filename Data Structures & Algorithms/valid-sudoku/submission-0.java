class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i=0; i<9; i++) {
            rows[i] = new HashSet<>();
        }
        for (int i=0; i<9; i++) {
            cols[i] = new HashSet<>();
        }
        for (int i=0; i<9; i++) {
            boxes[i] = new HashSet<>();
        }
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char number = board[i][j];
                if (number == '.')
                    continue;
                int boxIdx = (i / 3) * 3 + (j / 3);
                System.out.println("" + i + " " + j);
                if (rows[i].contains(number) || cols[j].contains(number) || boxes[boxIdx].contains(number)) {
                    return false;
                }
                rows[i].add(number);
                cols[j].add(number);
                boxes[boxIdx].add(number);
            }
        }
        return true;
    }
}
