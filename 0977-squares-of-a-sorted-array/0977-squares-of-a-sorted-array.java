class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int pos = n - 1;
        int[] res = new int[n];

        while (left <= right){

            int left_no = nums[left] * nums[left];
            int right_no = nums[right] * nums[right];

            if (left_no >= right_no){
                res[pos--] = left_no;
                left++;
            }
            else {
                res[pos--] = right_no;
                right--;
            }
        }
        return res;
    }
}