class Solution {
    public int maximumSum(int[] arr) {

        int oneDelete = Integer.MIN_VALUE;
        int keep = arr[0];
        int res = arr[0];
        int n = arr.length;

        for (int i = 1; i < n; i++){

            int prevKeep = keep;
            int prevDelete = oneDelete;

            keep = Math.max(arr[i], keep + arr[i]);

            if (prevDelete == Integer.MIN_VALUE){
                oneDelete = prevKeep; 
            }
            else {
                oneDelete = Math.max(prevKeep, oneDelete + arr[i]);
            }
            
            res = Math.max(res, Math.max(keep, oneDelete));
        }
        return res;
    }
}