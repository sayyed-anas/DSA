class Solution {
    public int subarraySum(int[] nums, int k) {

        int currSum = 0;
        int res = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        freq.put(0, 1);

        for (int i = 0; i < nums.length; i++){

            currSum = currSum + nums[i];

            if (freq.containsKey(currSum - k)){
                res = res + freq.get(currSum - k);
            }

            freq.put(currSum, freq.getOrDefault(currSum, 0) + 1);
        } 
        return res;
    }
}