class Solution {
    public int minSubArrayLen(int target, int[] nums) {

      int n = nums.length; 
      int low = 0;
      int minLength = Integer.MAX_VALUE;
      int sum = 0;

      for (int high = 0; high < n; high++){

        sum = sum + nums[high];

        while (sum >= target){

            if ((high - low) + 1 < minLength){
                 minLength = (high - low) + 1;
            }
            sum = sum - nums[low];
            low++;
        }
      }
      return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}