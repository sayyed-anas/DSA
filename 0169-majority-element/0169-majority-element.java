class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> freq = new HashMap<>();
        int max_freq = 0;
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++){

            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            // max_freq = Math.max(max_freq, freq.get(nums[i]));

            if (freq.get(nums[i]) > max_freq){
                max_freq = freq.get(nums[i]);
                ans = nums[i];
            }
        }

        return ans;
    }
}