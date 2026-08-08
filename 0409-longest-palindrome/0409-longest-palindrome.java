class Solution {
    public int longestPalindrome(String s) {
        
        int[] freq = new int[128];

        for (char ch : s.toCharArray()){
            freq[ch]++;
        }

        boolean hasOdd = false;
        int res = 0;

        for (int count : freq){
            res = res + count / 2 * 2;

            if (count % 2 == 1){
                hasOdd = true;
            }
        }

        if (hasOdd){
            res++;
        }

        return res;
    }
}