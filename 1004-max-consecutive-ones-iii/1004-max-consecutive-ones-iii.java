class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zc = 0;
        int res = 0;
        int low = 0;

        for (int high = 0; high < n; high++){
            if (nums[high] == 0){
                zc++;
            }

            while (zc > k){
                if (nums[low] == 0){
                    zc--;
                }
                low++;
            }

            res = Math.max(res, (high - low) + 1);
        }
        return res;
    }
}