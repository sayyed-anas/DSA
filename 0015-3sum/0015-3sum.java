import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < n-2; i++){

            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            int target = -1 * nums[i];
            int low = i + 1;
            int high = n - 1;

            while (low < high){
                
                int sum = nums[low] + nums[high];

                if (sum == target){
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[low], nums[high])));
                    low++;
                    high--;

                    while (low < n && nums[low] == nums[low-1]){
                        low++;
                    }
                    while (high >= 0 && nums[high] == nums[high+1]){
                        high--;
                    }
                }
                else if (sum > target){
                    high--;
                }
                else {
                    low++;
                }
            }
        }
        return list;
    }
}