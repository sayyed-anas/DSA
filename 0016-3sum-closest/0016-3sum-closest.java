import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;
        int mysum = 0;
        int diff = 0;
        int closest = closest = Integer.MAX_VALUE;

        for (int i = 0; i < n-2; i++){
            int left = i + 1;
            int right = n - 1;

            while (left < right){

                int sum = nums[i] + nums[left] + nums[right];
                diff = Math.abs(sum - target);

                if (diff < closest){
                    closest = diff;
                    mysum = sum;
                }

                if (sum == target){
                    return sum;
                }
                else if (sum > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
    return mysum;
    }
}