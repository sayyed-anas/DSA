class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int low = 0;
        int min_len = Integer.MAX_VALUE;
        int sum = 0;

        for (int high = 0; high < n; high++){

            sum = sum + nums[high];

            while (sum >= target){
                min_len = Math.min(min_len, (high - low) + 1);
                sum = sum - nums[low];
                low++;
            }
        }
        return min_len == Integer.MAX_VALUE ? 0 : min_len;
    }
}