class Solution {
    public boolean backtrack(char[][] board,int[][] vis,String word,int r,int c,int ind){

        if(ind==word.length()) return true;

        if(r>=board.length || r<0 || c>=board[0].length || c<0 || vis[r][c]==1 || word.charAt(ind)!=board[r][c]) return false;

        vis[r][c] = 1;
        ind = ind+1;

        if(backtrack(board, vis, word, r+1, c, ind) || backtrack(board, vis, word, r-1, c, ind)
        || backtrack(board, vis, word, r, c+1, ind) || backtrack(board, vis, word, r, c-1, ind))
        return true;
        
        ind = ind - 1;
        vis[r][c] = 0;

        return false;

    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
               if(backtrack(board, vis, word, i, j, 0)) 
                return true;
            }
        }

        return false;
    }
}
