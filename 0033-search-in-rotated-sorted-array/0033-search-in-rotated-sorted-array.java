class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[mid] > nums[n-1]) {

                if (nums[mid] < target){
                    low = mid + 1;
                }
                else {
                    if (nums[0] > target){
                        low = mid + 1;
                    }
                    else {
                        high = mid - 1;
                    }
                }
                continue;
            }
            else {
                if (nums[mid] > target){
                    high = mid - 1;
                }
                else {
                    if (nums[n -1] < target){
                        high = mid - 1;
                    }
                    else {
                        low = mid + 1;
                    }
                }
            }
        }

        return -1;
    }
}