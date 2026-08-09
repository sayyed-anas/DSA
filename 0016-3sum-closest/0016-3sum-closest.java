import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        int min_diff = Integer.MAX_VALUE;
        int closest_sum = 0;

        for (int i = 0; i < n; i++){

            int low = i + 1;
            int high = n - 1;

            while (low < high){
                int curr_sum = nums[i] + nums[low] + nums[high];
                int diff = Math.abs(curr_sum - target);

                if (diff < min_diff){
                    min_diff = diff;
                    closest_sum = curr_sum;
                }

                if (curr_sum == target){
                    return curr_sum;
                }
                else if (curr_sum > target){
                    high--;
                }
                else {
                    low++;
                }
            }
        }
        return closest_sum;
    }
}