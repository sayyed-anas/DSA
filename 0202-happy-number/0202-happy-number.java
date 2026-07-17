class Solution {
    private static int mySum(int n){
        int sum = 0;
        while (n > 0){
            int digit = n % 10;
            sum = sum + digit * digit;
            n = n / 10;
        }
        return sum;
    }
    public boolean isHappy(int n){
       int slow = n;
       int fast = n;

       do {
        slow = mySum(slow);
        fast = mySum(mySum(fast));
       } while (slow != fast);

       return slow == 1;
    }
}