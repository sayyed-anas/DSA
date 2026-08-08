class Solution {
    public int search(int[] nums, int target) {
        
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int res = -1;

        while (low <= high){

            int mid = (low + high) / 2;

            if (nums[mid] > nums[n-1]){
                low = mid + 1;
            }
            else {
                res = mid;
                high = mid - 1;
            }
        }

        int low1 = 0;
        int high1 = res - 1;

        while (low1 <= high1){
            int mid1 = (low1 + high1) / 2;

            if (nums[mid1] == target){
                return mid1;
            }
            else if (nums[mid1] > target){
                high1 = mid1 - 1;
            }
            else {
                low1 = mid1 + 1;
            }
        }

        int low2 = res;
        int high2 = n - 1;

        while (low2 <= high2){
            int mid2 = (low2 + high2) / 2;

            if (nums[mid2] == target){
                return mid2;
            }
            else if (nums[mid2] > target){
                high2 = mid2 - 1;
            }
            else {
                low2 = mid2 + 1;
            }
        }
        return -1;
    }
}