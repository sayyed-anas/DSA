class Solution {
    private static int kElementCount(int[][] matrix, int target){

        int col = 0;
        int row = matrix.length - 1;
        int count = 0;

        while (row >= 0 && col < matrix[0].length){

            if (matrix[row][col] > target){
                row--;
            }
            else {
                count = count + row + 1;
                col++;
            }
        }
        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
       
       int n = matrix.length;
       int low = matrix[0][0];
       int high = matrix[n -1][n - 1];
       int res = 0;

       while (low <= high){

        int mid = (low + high) / 2;
        int no_of_kthElem = kElementCount(matrix, mid);

        if (no_of_kthElem >= k){
            res = mid;
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
       } 
       return res;
    }
}