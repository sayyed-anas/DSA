class Solution {
    public int maxSubarraySumCircular(int[] nums) {

       int minEnding = 0;
       int minSum = nums[0];
       int maxEnding = 0;
       int maxSum = nums[0];
       int totalSum = 0;

       for (int i = 0; i < nums.length; i++){

        minEnding = Math.min(nums[i], minEnding + nums[i]);
        minSum = Math.min(minSum, minEnding);

        maxEnding = Math.max(nums[i], maxEnding + nums[i]);
        maxSum = Math.max(maxSum, maxEnding);

        totalSum = totalSum + nums[i];
       }

       if (maxSum < 0){
        return maxSum;
       }

       return Math.max(totalSum - minSum, maxSum);
    }
}