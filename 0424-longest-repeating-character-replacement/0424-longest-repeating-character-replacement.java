class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int low = 0;
        int[] res = new int[26];
        int max_freq = Integer.MIN_VALUE;
        int max_len = 0;

        for (int high = 0; high < n; high++){
            
            char rightChar = s.charAt(high);
            res[rightChar - 'A']++;
            max_freq = Math.max(max_freq, res[rightChar - 'A']);

            while(((high - low) + 1 - max_freq) > k){

                char leftChar = s.charAt(low);
                res[leftChar - 'A']--;
                low++;
            }

            max_len = Math.max(max_len, (high - low) + 1);
        }
        return max_len;
    }
}