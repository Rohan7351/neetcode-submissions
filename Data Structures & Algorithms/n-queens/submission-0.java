class Solution {

    public boolean isPossible(int[][] arr, int n, int row, int col) {

    // 1. Upper-left diagonal ↖
    int i = row;
    int j = col;

    while (i >= 0 && j >= 0) {
        if (arr[i][j] == 1) {
            return false;
        }
        i--;
        j--;
    }

    // 2. Same row, moving left ←
    i = row;
    j = col;

    while (j >= 0) {
        if (arr[i][j] == 1) {
            return false;
        }
        j--;
    }

    // 3. Lower-left diagonal ↙
    i = row;
    j = col;

    while (i < n && j >= 0) {
        if (arr[i][j] == 1) {
            return false;
        }
        i++;
        j--;
    }

    return true;
}

    public void helper(int[][] arr, int n, int col,
                       List<List<String>> ans) {

        // All columns filled
        if (col == n) {

            List<String> board = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                StringBuilder row = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        row.append('Q');
                    } else {
                        row.append('.');
                    }
                }

                board.add(row.toString());
            }

            ans.add(board);
            return;
        }

        // Try every row in current column
        for (int row = 0; row < n; row++) {

            if (isPossible(arr, n, row, col)) {

                // Choose
                arr[row][col] = 1;

                // Explore
                helper(arr, n, col + 1, ans);

                // Undo
                arr[row][col] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        int[][] arr = new int[n][n];

        List<List<String>> ans = new ArrayList<>();

        helper(arr, n, 0, ans);

        return ans;
    }
}