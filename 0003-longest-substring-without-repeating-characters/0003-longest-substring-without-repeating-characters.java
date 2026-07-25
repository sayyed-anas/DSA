class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> freq = new HashMap<>();
        int n = s.length();
        int low = 0;
        int max_len = 0;

        for (int high = 0; high < n; high++){

            freq.put(s.charAt(high), freq.getOrDefault(s.charAt(high), 0) + 1);
            int len = high - low + 1;

            while (len > freq.size()){

                char leftChar = s.charAt(low);

                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0){
                    freq.remove(leftChar);
                }

                low++;
                len = high - low + 1;
            }

            if (freq.size() >= len){
                max_len = Math.max(max_len, len);
            }
        }
        return max_len;
    }
}