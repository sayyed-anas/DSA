import java.util.*;

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

            char rightChar = s2.charAt(high);
            window[rightChar - 'a']++;

            if ((high - low) + 1 > s1.length()){
                char leftChar = s2.charAt(low);
                window[leftChar - 'a']--;
                low++;
            } 

            if (Arrays.equals(need, window)){
                return true;
            }
        }
        return false;
    }
}