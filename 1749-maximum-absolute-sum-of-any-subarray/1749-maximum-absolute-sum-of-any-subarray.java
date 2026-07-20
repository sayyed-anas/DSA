class Solution {
    private static int minSum(int[] nums, int n){

        int minEnding = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++){
            int v1 = nums[i];
            int v2 = minEnding + nums[i];

            minEnding = Math.min(v1, v2);
            res = Math.min(res, minEnding);
        }
        return Math.abs(res);
    }

    private static int maxSum(int[] nums, int n){

        int res = nums[0];
        int maxEnding = nums[0];

        for (int i = 1; i < n; i++){
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            res = Math.max(res, maxEnding);
        }
        return Math.abs(res);
    }
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        return Math.max(minSum(nums,n), maxSum(nums,n));
    }
}