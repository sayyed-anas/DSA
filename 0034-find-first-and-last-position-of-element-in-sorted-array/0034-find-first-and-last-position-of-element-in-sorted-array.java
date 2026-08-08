class Solution {
    private static int lower(int[] nums, int n, int x){
        int low = 0;
        int high = n - 1;
        int res = -1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (nums[mid] < x){
                low = mid + 1;
            }
            else if (nums[mid] > x){
                high = mid - 1;
            }
            else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    private static int higher(int[] nums, int n, int x){
        int low = 0;
        int high = n - 1;
        int res = -1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (nums[mid] < x){
                low = mid + 1;
            }
            else if (nums[mid] > x){
                high = mid - 1;
            }
            else {
                res = mid;
                low = mid + 1;
            }
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        return new int[]{lower(nums,n,target),higher(nums,n,target)};
    }
}