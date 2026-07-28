class Solution {
    private static int maximumSum(int[] nums){

        int maxEnding = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++){
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            maxSum = Math.max(maxSum, maxEnding);
        }
        return Math.abs(maxSum);
    }

    private static int minimumSum(int[] nums){

        int minSum = nums[0];
        int minEnding = nums[0];

        for (int i = 1; i < nums.length; i++){
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSum = Math.min(minSum, minEnding);
        }
        return Math.abs(minSum);
    }

    public int maxAbsoluteSum(int[] nums) {
        if (maximumSum(nums) > minimumSum(nums)){
            return maximumSum(nums);
        }
        else {
            return minimumSum(nums);
        }
    }
}