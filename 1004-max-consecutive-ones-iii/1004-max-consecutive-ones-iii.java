class Solution {
    public int longestOnes(int[] nums, int k) {

        int zeroCounter = 0;
        int n = nums.length;
        int low = 0;
        int max_len = 0;

        for (int high = 0; high < n; high++){
            if (nums[high] == 0){
                zeroCounter++;
            }

            while (zeroCounter > k){
                if (nums[low] == 0){
                    zeroCounter--;
                }
                low++;
            }
            max_len = Math.max(max_len, high - low + 1);
        }
        return max_len;
    }
}