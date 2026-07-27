class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()){
            return false;
        }

        int low = 0;
        int[] need = new int[26];
        int[] window = new int[26];

        for (char ch : s1.toCharArray()){
            need[ch - 'a']++;
        }

        for (int high = 0; high < s2.length(); high++){

            window[s2.charAt(high) - 'a']++;

            if ((high - low) + 1 > s1.length()){
                window[s2.charAt(low) - 'a']--;
                low++;
            }

            if (java.util.Arrays.equals(need,window)){
                return true;
            }
        }
        return false;
    }
}