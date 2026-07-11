class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int n = nums.length;
        int sum = 0;
        int len = Integer.MAX_VALUE;

        for (int high = 0; high < n; high++){
            sum = sum + nums[high];

            while(sum >= target){

                len = Math.min(len, (high - low) + 1);
                sum = sum - nums[low];
                low++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}