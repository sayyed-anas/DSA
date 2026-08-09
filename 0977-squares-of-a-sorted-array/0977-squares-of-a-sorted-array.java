class Solution {
    public int[] sortedSquares(int[] nums) {
       
       int n = nums.length;
       int low = 0;
       int high = n - 1;
       int res[] = new int[n];
       int pos = n - 1;

       while (low <= high){

            int left = nums[low] * nums[low];
            int right = nums[high] * nums[high];

            if (left > right){
                res[pos--] = left;
                low++;
            }
            else {
                res[pos--] = right;
                high--;
            }
       }
       return res;
    }
}