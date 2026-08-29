class Solution {
    public int removeDuplicates(int[] nums) {

        int left = 1;
        int n = nums.length;

        for (int right = 1; right < n; right++){

            if (nums[right] == nums[right-1]){
                continue;
            }
            else {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}