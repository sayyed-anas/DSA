class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        boolean insert = false;

        for (int i = 0; i < intervals.length; i++){
            if (insert == false && intervals[i][0] >= newInterval[0]){
                list.add(new int[]{newInterval[0],newInterval[1]});
                insert = true;
            }
            list.add(new int[]{intervals[i][0], intervals[i][1]});
        }

        if (!insert) {
            list.add(newInterval);
        }

        int[][] ans = list.toArray(new int[list.size()][]);
        

        int start1 = ans[0][0];
        int end1 = ans[0][1];

        ArrayList<int[]> list1 = new ArrayList<>();

        for (int i = 1; i < ans.length; i++){
            int start2 = ans[i][0];
            int end2 = ans[i][1];

            if (end1 >= start2){
                start1 = start1;
                end1 = Math.max(end1, end2);
                continue;
            }

            list1.add(new int[]{start1,end1});

            start1 = start2;
            end1 = end2;
        }
        list1.add(new int[]{start1,end1});

        return list1.toArray(new int[list1.size()][]);
    }
}