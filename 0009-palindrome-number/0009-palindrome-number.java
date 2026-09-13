class Solution {
    public boolean isPalindrome(int x) {

        // if (x < 0){
        //     return false;
        // }
        
        int rev = 0;
        int n = x;

        while (x > 0){

            int lastDigit = x % 10;
            x = x / 10;

            rev = (rev * 10) + lastDigit;
        }

        if (rev == n){
            return true;
        }

        return false;
    }
}