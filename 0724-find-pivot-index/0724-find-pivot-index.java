class Solution {
    public int pivotIndex(int[] nums) {

        int left = 0;
        int totalSum = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++){
            totalSum += nums[i];
        }

        for (int i = 0; i < n; i++){
            int right = totalSum - left - nums[i];

            if (left == right){
                return i;
            }
            left = left + nums[i];
        }
        return -1;
    }
}