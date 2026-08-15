class Solution {
    public int maxProduct(int[] nums) {
        
        int minEnding = nums[0];
        int maxEnding = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++){

            int currMin = minEnding * nums[i];
            int currMax = maxEnding * nums[i];

            minEnding = Math.min(nums[i], Math.min(currMin, currMax));
            maxEnding = Math.max(nums[i], Math.max(currMin, currMax));

            res = Math.max(res, Math.max(minEnding, maxEnding));
        }

        return res;
    }
}