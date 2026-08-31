class Pairs<T,U> {
    T first;
    U second;

    Pairs(T first, U second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<Pairs<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b) -> {
                if (!a.first.equals(b.first)){
                    return a.first - b.first;
                }

                return a.second - b.second;
            }
        );

        int n = nums.length;
        HashMap<Integer,Integer> freq = new HashMap<>();

        for (int elem : nums){
            freq.put(elem, freq.getOrDefault(elem, 0) + 1);
        }

        for (Map.Entry<Integer,Integer> entry : freq.entrySet()){

            int elem = entry.getKey();
            int f = entry.getValue();

            Pairs<Integer,Integer> currPair = new Pairs<>(f,elem);

            if (pq.size() < k){
                pq.add(currPair);
            }
            else if (currPair.first > pq.peek().first){
                pq.poll();
                pq.add(currPair);
            }
        }

        int[] res = new int[k];
        int pos = 0;

        while (!pq.isEmpty()){
            res[pos++] = pq.poll().second;
        }

        return res;
    }
}