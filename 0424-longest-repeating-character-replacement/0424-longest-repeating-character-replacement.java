class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int low = 0;
        int max_freq = Integer.MIN_VALUE;
        int[] arr = new int[26];
        int res = 0;

        for (int high = 0; high < n; high++){
            char ch = s.charAt(high);
            arr[ch - 'A']++;
            max_freq = Math.max(max_freq,arr[ch - 'A']);

            while ((high - low) + 1 - max_freq > k){
                char leftChar = s.charAt(low);
                arr[leftChar - 'A']--;
                low++;
            }

            res = Math.max(res,(high - low) + 1);
        }
        return res;
    }
}