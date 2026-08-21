class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int low = 0;
        int high = n - 1;
        int row = 0;

        while (low <= high){

            int mid = (low + high) / 2;

            if (matrix[mid][0] > target){
               high = mid - 1;
            }
            else {
               row = mid;
               low = mid + 1; 
            }
        }

        // if (row == -1){
        //     return false;
        // }

        int left = 0;
        int right = matrix[row].length - 1;
        int res = -1;

        while (left <= right){

            int mid = (left + right) / 2;

            if (matrix[row][mid] == target){
                return true;
            }
            else if (matrix[row][mid] > target){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}