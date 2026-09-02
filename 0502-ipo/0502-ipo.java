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

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        while (k-- != 0){
            while (idx < proj.length){

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