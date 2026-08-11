class Solution {
    public boolean isSameAfterReversals(int num) {
        
        // int rev1 = 0;
        // int rev2 = 0;
        // int numCheck = num;

        // while (num != 0){

        //     int digit = num % 10;
        //     num = num / 10;

        //     rev1 = rev1 * 10 + digit;
        // }

        // while (rev1 != 0){

        //     int digit = rev1 % 10;
        //     rev1 = rev1 / 10;

        //     rev2 = rev2 * 10 + digit;
        // }

        // return rev2 == numCheck;

        return num == 0 || num % 10 != 0;
    }
}