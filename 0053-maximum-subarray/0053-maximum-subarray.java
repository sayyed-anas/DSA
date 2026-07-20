class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int res = nums[0];
        int bestEnding = nums[0];

        for (int i = 1; i < n; i++){
            int v1 = nums[i];
            int v2 = bestEnding + nums[i];

            bestEnding = Math.max(v1, v2);
            res = Math.max(res, bestEnding);
        }
        return res;
    }
}