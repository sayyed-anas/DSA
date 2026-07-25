class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int min_len = Integer.MAX_VALUE;
        int sum = 0;
        int low = 0;
        int n = nums.length;

        for (int high = 0; high < n; high++){
            sum = sum + nums[high];

            while (sum >= target){
                int len = high - low + 1;
                min_len = Math.min(min_len, len);
                
                sum = sum - nums[low];
                low++;
            }
        } 
        return (min_len == Integer.MAX_VALUE ? 0 : min_len);
    }
}