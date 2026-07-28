class Solution {
    public int pivotIndex(int[] nums) {

        int left = 0;  
        int right = 0;
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++){
            totalSum = totalSum + nums[i];
        }

        for (int i = 0; i < nums.length; i++){

            right = totalSum - left - nums[i];

            if (left == right){
                return i;
            }

            left = left + nums[i];   
        }
        return -1;
    }
}