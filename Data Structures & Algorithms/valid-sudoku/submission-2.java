class Solution {
    
    public boolean travesalBox(char[][] board, int sr, int er, int sc, int ec){

        Set<Character> s = new HashSet<>();

        for(int row=sr;row<=er;row++){
            for(int col=sc;col<=ec;col++){
                if(board[row][col]=='.') continue;
                if(s.contains(board[row][col])) return false;
                s.add(board[row][col]);
            }
        }

        return true;

    }

    public boolean isValidSudoku(char[][] board) {
       
        // Step 1 : Validate rows 
        for(int row=0;row<9;row++){
            Set<Character> s = new HashSet<>();
            for(int col=0;col<9;col++){
                if(board[row][col]=='.') continue;
                if(s.contains(board[row][col])) return false;
                s.add(board[row][col]);
            }
        }


        // Step 2 : Validate the columns
        for(int col=0;col<9;col++){
            Set<Character> s = new HashSet<>();
            for(int row=0;row<9;row++){
               if(board[row][col]=='.') continue;
               if(s.contains(board[row][col])) return false;
               s.add(board[row][col]);
            }
        }


        // Step 3 : Validate the Box (3 X 3)
          // for(int sr=0;sr<9;sr+=3){
          //     int er = sr+2;
          //     for(int sc=0;sc<9;sc+=3){
          //        int ec = sc+2;
          //         if(!travesalBox(board, sr, er, sc, ec)) return false;
          //     }
          // }

          Set<String> s = new HashSet<>();
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                char curr = board[row][col];
                if(curr=='.') continue;
                int sr = row/3;
                int sc = col/3;
                String str = sr + "-" + sc + "-" + curr;
                if(s.contains(str)) return false;
                s.add(str);
            }
        }

        return true;
        


    }
}
