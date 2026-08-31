import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int elem : nums){

            if (pq.size() < k){
                pq.add(elem);
            }
            else if (pq.peek() < elem){
                pq.poll();
                pq.add(elem);
            }
        }
        return pq.peek();
    }
}