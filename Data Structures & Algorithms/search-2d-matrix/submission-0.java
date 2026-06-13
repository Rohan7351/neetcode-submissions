class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;   // 3
        int m = matrix[0].length; // 4

        int l = 0;
        int r = n-1;
        int row  = -1;

        while(l<=r){
          int mid = r-(r-l)/2;

          if(matrix[mid][0]==target){
                return true;
          }else if(matrix[mid][0]<target){
                row = mid;
                l = mid+1;
          }else{
                r = mid-1;
          }
        }

        if(row==-1) return false;

         l = 0;
         r = m-1;

         while(l<=r){
          int mid = r-(r-l)/2;
          if(matrix[row][mid]==target){
                return true;
          }else if(matrix[row][mid]<target){
                l = mid+1;
          }else{
                r = mid-1;
          }
        }

        return false;



    }
}
