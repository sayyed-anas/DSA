class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int low = 0;
        int maxLen = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++){

            char rightChar = s.charAt(high);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);

            while (freq.size() < (high - low) + 1){

                char leftChar = s.charAt(low);
                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0){
                    freq.remove(leftChar);
                }

                low++;
            }

            maxLen = Math.max(maxLen, (high - low) + 1);
        }
        return maxLen;
    }
}