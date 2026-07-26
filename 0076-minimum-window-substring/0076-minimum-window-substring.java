class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()){
            return "";
        }

        int[] freq = new int[128];
        int low = 0;
        int matched = 0;
        int min_len = Integer.MAX_VALUE;
        int start = 0;
        int n = s.length();

        for (char ch : t.toCharArray()){
            freq[ch]++;
        }

        for (int high = 0; high < n; high++){
            
            char rightChar = s.charAt(high);

            if (freq[rightChar] > 0){
                matched++;
            }
            
            freq[rightChar]--;

            while (matched == t.length()){
                if ((high - low) + 1 < min_len){
                    min_len = (high - low) + 1;
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
        return min_len == Integer.MAX_VALUE ? "" : s.substring(start, start+min_len);
    }
}