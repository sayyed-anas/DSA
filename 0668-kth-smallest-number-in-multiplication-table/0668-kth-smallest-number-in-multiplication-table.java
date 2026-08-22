class Solution {
    private static int countLessK(int row, int col, int k, int target){

        int count = 0;
        int curr_row = row;
        int curr_col = 1;
        
        while (curr_row >= 1 && curr_col <= col){

            if ((curr_row * curr_col) > target){
                curr_row--;
            }
            else {
                count = count + curr_row;
                curr_col++;
            }
        }
        return count;
    }

    public int findKthNumber(int m, int n, int k) {  

        int low = 1;
        int high = n * m;
        int res = 0;

        while (low <= high){

            int mid = (low + high) / 2;
            int lessCount = countLessK(m, n, k, mid);

            if (lessCount < k){
                low = mid + 1;
            }
            else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }
}