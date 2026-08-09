class Solution {

    private static long eating(int[] piles, int n, int speed){

        long hour = 0;
        for (int pile : piles){
            hour += pile / speed;

            if (pile % speed != 0){
                hour++;
            }
        }

        return hour;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;
        int low = 1;
        int high = 0;
        int res = -1;

        for (int pile : piles){
            high = Math.max(high, pile);
        }

        while (low <= high){

            int mid = (low + high) / 2;

            long hours = eating(piles,n,mid);

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