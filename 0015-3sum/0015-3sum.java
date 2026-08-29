import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n - 2; i++){

            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int target = -1 * nums[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right){

                int currSum = nums[left] + nums[right];

                if (currSum == target){
                    list.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;
                    right--;

                    while (left < n && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (right >= 0 && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
                else if (currSum < target){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return list;
    }
}