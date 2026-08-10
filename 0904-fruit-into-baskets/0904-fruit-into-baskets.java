class Solution {
    public int totalFruit(int[] fruits) {

        int n = fruits.length;
        int maxFruits = Integer.MIN_VALUE;
        int low = 0;
        int k = 2;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++){

            int rightFruit = fruits[high];
            freq.put(rightFruit, freq.getOrDefault(rightFruit, 0) + 1);

            while (freq.size() > k){

                int leftFruit = fruits[low];
                freq.put(leftFruit, freq.get(leftFruit) - 1);

                if (freq.get(leftFruit) == 0){
                    freq.remove(leftFruit);
                }

                low++;
            }
            
            maxFruits = Integer.max(maxFruits, (high - low) + 1);
        }
        return maxFruits == Integer.MIN_VALUE ? -1 : maxFruits;
    }
}