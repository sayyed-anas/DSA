class Solution {
    public int removeDuplicates(int[] nums) {

      int n = nums.length;
      int left = 1;
      int right = 1;

      while (right < n){
        if (nums[right] == nums[right - 1]){
            right++;
        }
        else {
            nums[left++] = nums[right++];
        }
      }
      return left;
    }
}