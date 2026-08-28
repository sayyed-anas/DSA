import java.util.*;

class Pairs<T, U> {

    T first;
    U second;

    Pairs(T first, U second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        PriorityQueue<Pairs<Integer, Integer>> heap =
            new PriorityQueue<>(
                (a, b) -> {
                    if (!a.first.equals(b.first)) {
                        return Integer.compare(a.first, b.first);
                    }
                    return Integer.compare(a.second, b.second);
                }
            );

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequencies
        for (int i = 0; i < n; i++) {
            freq.put(
                nums[i],
                freq.getOrDefault(nums[i], 0) + 1
            );
        }

        // Keep k most frequent elements
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

            int element = entry.getKey();
            int frq = entry.getValue();

            Pairs<Integer, Integer> curr =
                new Pairs<>(frq, element);

            if (heap.size() < k) {
                heap.add(curr);
            } else if (curr.first > heap.peek().first) {
                heap.poll();
                heap.add(curr);
            }
        }

        int[] res = new int[k];

        // Extract elements
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().second;
        }

        return res;
    }
}