class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;   // 3
        int m = matrix[0].length; // 4

        int l = 0;
        int r = m*n-1;
        while(l<=r){
          int mid = l+(r-l)/2;

          int row = mid/m;
          int col = mid%m;

          if(matrix[row][col]==target){
                return true;
          }else if(matrix[row][col]<target){
                l = mid+1;
          }else{
                r = mid-1;
          }
        }

        return false;



    }
}
