class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int low = 0;
        List<Integer> startIndexes = new ArrayList<>();
        int[] need = new int[26];
        int[] window = new int[26];

        for (char ch : p.toCharArray()){
            need[ch - 'a']++;
        }

        for (int high = 0; high < s.length(); high++){

            char rightChar = s.charAt(high);
            window[rightChar - 'a']++;

            if ((high - low) + 1 > p.length()){
                char leftChar = s.charAt(low);
                window[leftChar - 'a']--;
                low++;
            }

            if (Arrays.equals(need, window)){
                startIndexes.add(low);
            }
        }
        return startIndexes;
    }
}