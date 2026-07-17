class Solution {
    private static int squaredSum (int n){
        int sum = 0;

        while (n > 0){
            int digit = n % 10;
            sum = sum + digit * digit;
            n = n / 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = squaredSum(slow);
            fast = squaredSum(squaredSum(fast));
        } while(slow != fast && fast != 1);

        return fast == 1;
    }
}