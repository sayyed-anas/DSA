class Solution {
    public int longestOnes(int[] nums, int k) {

        int zeroCount = 0;
        int n = nums.length; 
        int low = 0;
        int maximumConsecutiveOnes = 0;

        for (int high = 0; high < n; high++){

            if (nums[high] == 0){
                zeroCount++;
            }

            while (zeroCount > k){
                
                if (nums[low] == 0){
                    zeroCount--;
                }

                low++;
            }

            maximumConsecutiveOnes = Math.max(maximumConsecutiveOnes, (high - low) + 1);
        }   
        return maximumConsecutiveOnes;
    }
}