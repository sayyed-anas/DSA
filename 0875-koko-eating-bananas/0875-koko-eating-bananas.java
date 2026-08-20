class Solution {

    private static long eatingTime (int[] piles, int n, int speed){

        long h = 0;

        for (int i = 0; i < n; i++){

            h = h + piles[i] / speed;

            if (piles[i] % speed != 0){
                h++;
            }
        }
        return h;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = Integer.MIN_VALUE;
        int res = -1;

        for (int pile : piles) {
            if (high < pile){
                high = pile;
            }
        }

        while (low <= high) {

            int mid = (low + high) / 2;
            long hours = eatingTime(piles, piles.length, mid);

            if (hours > h){
                low = mid + 1;
            }
            else {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }
}