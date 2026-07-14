class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();
       int low = 0;
       int res = 0;
       HashMap<Character, Integer> freq = new HashMap<>();

       for (int high = 0; high < n; high++){
        char ch = s.charAt(high);
        freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        int k = (high - low) + 1;

        while (freq.size() < k){
            char leftChar = s.charAt(low);
            freq.put(leftChar, freq.get(leftChar) - 1);

            if (freq.get(leftChar) == 0){
                freq.remove(leftChar);
            }
            low++;
            k = (high - low) + 1;
        }

        if (freq.size() == k){
            int len = (high - low) + 1;
            res = Math.max(res, len);
        }
       }
       return res;
    }
}