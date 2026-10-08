class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;
        int greater = n / 3;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++){
            int count = 0;
            for (int j = 0; j < n; j++){

                if (nums[i] == nums[j]){
                    count++;
                }
            }
            if (count > greater && !res.contains(nums[i])){
                res.add(nums[i]);
            }
        }

        return res;
    }
}