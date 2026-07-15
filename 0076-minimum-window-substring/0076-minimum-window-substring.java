class Solution {
    public String minWindow(String s, String t) {
       
       if (s.length() < t.length()){
        return "";
       }

       int[] freq = new int[128];

       for (char ch : t.toCharArray()){
        freq[ch]++;
       }

       int matched = 0;
       int low = 0;
       int start = 0;
       int minLen = Integer.MAX_VALUE;

       for (int high = 0; high < s.length(); high++){

        char rightChar = s.charAt(high);

        if (freq[rightChar] > 0){
            matched++;
        }

        freq[rightChar]--;

        while(matched == t.length()){
            if ((high - low) + 1 < minLen){
                minLen = (high - low) + 1;
                start = low;
            }

            char leftChar = s.charAt(low);

            freq[leftChar]++;

            if (freq[leftChar] > 0){
                matched--;
            }

            low++;
        }
       }
       return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}