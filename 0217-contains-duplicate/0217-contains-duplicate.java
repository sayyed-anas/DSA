import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int i = 1;
        int n = nums.length;

        Arrays.sort(nums);

        while (i < n){
            if (nums[i] == nums[i - 1]){
                return true;
            }

            i++;
        }
        return false;
    }  
}