class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int minEnding = nums[0];
        int maxEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++){
            int currElem = nums[i];
            int currMin = minEnding * nums[i];
            int currMax = maxEnding * nums[i];

            minEnding = Math.min(currElem, Math.min(currMin, currMax));
            maxEnding = Math.max(currElem, Math.max(currMin, currMax));

            ans = Math.max(ans, Math.max(minEnding, maxEnding));
        }
        return ans;
    }
}