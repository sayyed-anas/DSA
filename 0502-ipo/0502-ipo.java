class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = capital.length;
        int[][] proj = new int[n][2];

        for (int i = 0; i < n; i++){
            proj[i][0] = capital[i];
            proj[i][1] = profits[i];
        }

        Arrays.sort(proj,
            (a,b) -> {
                return a[0] - b[0];
            }
        );

        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (k-- != 0){
            while (idx < n){

                if (proj[idx][0] > w){
                    break;
                }

                pq.add(proj[idx][1]);
                idx++;
            }

            if (pq.isEmpty()){
                return w;
            }

            w = w + pq.poll();
        }

        return w;
    }
}