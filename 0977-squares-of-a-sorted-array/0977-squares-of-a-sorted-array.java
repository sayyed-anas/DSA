import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int pos = n - 1;
        int[] res = new int[n];

        while (i <= j){
            int l = nums[i] * nums[i];
            int r = nums[j] * nums[j];

            if (l > r){
                res[pos--] = l;
                i++;
            }
            else {
                res[pos--] = r;
                j--;
            }
        }
        return res;
    }
}