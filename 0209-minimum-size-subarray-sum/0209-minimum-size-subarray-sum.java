class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int low = 0;

        for (int high = 0; high < n; high++){

            sum = sum + nums[high];

            while (sum >= target){
                int len = (high - low) + 1;
                res = Math.min(res,len);
                sum = sum - nums[low];
                low++;
            }
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }
}