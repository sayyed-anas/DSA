class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int res = nums[0];
        int total = 0;
        int n = nums.length;
        int maxEnding = 0;
        int maxSum = nums[0];
        int minEnding = 0;
        int minSum = nums[0];

        for (int i = 0; i < n; i++){
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            maxSum = Math.max(maxSum, maxEnding);

            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSum = Math.min(minSum, minEnding);

            total = total + nums[i];

            res = Math.max(maxSum, total - minSum);
        }
        if (maxSum < 0){
            return maxSum;
        }

        return res;
    }
}