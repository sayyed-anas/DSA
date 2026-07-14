class Solution {
    public int totalFruit(int[] fruits) {
        int k = 2;
        int n = fruits.length;
        int res = -1;
        int low = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int high = 0; high < n; high++){
            hm.put(fruits[high], hm.getOrDefault(fruits[high], 0) + 1);

            while (hm.size() > k){
                hm.put(fruits[low], hm.get(fruits[low]) - 1);

                if (hm.get(fruits[low]) == 0){
                    hm.remove(fruits[low]);
                }

                low++;
            }

            if (hm.size() == k || hm.size() < k){
                int len = (high - low) + 1;
                res = Math.max(res, len);
            }
        }
        return res;
    }
}