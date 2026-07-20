class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int minEnding = 0;
        int minSum = nums[0];
        int maxEnding = 0;
        int maxSum = nums[0];

        int totalSum = 0;

        for (int i = 0; i < n; i++){
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSum = Math.min(minSum, minEnding);

            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            maxSum = Math.max(maxSum, maxEnding);

            totalSum += nums[i];
        }
        
        if (maxSum < 0){
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}