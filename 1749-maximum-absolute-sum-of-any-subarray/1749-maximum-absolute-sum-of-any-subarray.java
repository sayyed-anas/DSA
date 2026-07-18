class Solution {

    private static int minSum(int[] nums){
        int minEnding = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int v1 = nums[i];
            int v2 = nums[i] + minEnding;

            minEnding = Math.min(v1, v2);
            res = Math.min(res, minEnding);
        }
        return Math.abs(res);
    }

    private static int maxSum(int[] nums){
        int maxEnding = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++){
            int v1 = nums[i];
            int v2 = nums[i] + maxEnding;

            maxEnding = Math.max(v1, v2);
            res = Math.max(res, maxEnding);
        }
        return Math.abs(res);
    }

    public int maxAbsoluteSum(int[] nums) {
      return Math.max(minSum(nums), maxSum(nums));
    }
}