class Solution {
    public int maximumSum(int[] arr) {

        int n = arr.length;
        int keep = arr[0];
        int res = arr[0];
        int delete = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++){
            int prevKeep = keep;
            int prevDelete = delete;

            keep = Math.max(arr[i], keep + arr[i]);

            if (prevDelete == Integer.MIN_VALUE){
                delete = prevKeep;
            }
            else {
                delete = Math.max(prevKeep, delete + arr[i]);
            }
            res = Math.max(res, Math.max(keep, delete));
        }
        return res;
    }
}