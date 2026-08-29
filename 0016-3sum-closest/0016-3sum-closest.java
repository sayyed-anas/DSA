import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        int min_diff = Integer.MAX_VALUE;
        int resSum = 0;

        for (int i = 0; i < n - 2; i++){

            int left = i + 1;
            int right = n - 1;

            while (left < right){

                int currSum = nums[i] + nums[left] + nums[right];
                int currDiff = Math.abs(currSum - target);

                if (currDiff < min_diff){
                    min_diff = currDiff;
                    resSum = currSum;
                }

                if (currSum == target){
                    return currSum;
                }
                else if (currSum > target){
                    right--;
                }
                else {
                    left++;
                }
            }
        }  
        return resSum;
    }
}