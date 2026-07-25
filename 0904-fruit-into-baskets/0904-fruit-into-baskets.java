class Solution {
    public int totalFruit(int[] fruits) {

        int k = 2;
        int n = fruits.length;
        int low = 0;
        int max_len = Integer.MIN_VALUE;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++){

            freq.put(fruits[high], freq.getOrDefault(fruits[high], 0) + 1);

            while (freq.size() > k){
                freq.put(fruits[low], freq.get(fruits[low]) - 1);

                if (freq.get(fruits[low]) == 0){
                    freq.remove(fruits[low]);
                }
                low++;
            }

            if (freq.size() <= k){
                int len = high - low + 1;
                max_len = Math.max(max_len, len);
            }

        }
        return max_len == Integer.MIN_VALUE ? 0 : max_len;
    }
}