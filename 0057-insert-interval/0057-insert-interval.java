class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0){
            return new int[][]{newInterval};
        }

        ArrayList<int[]> list = new ArrayList<>();
        boolean insert = false;

        for (int i = 0; i < intervals.length; i++){

            if (insert == false && intervals[i][0] >= newInterval[0]){
                list.add(newInterval);
                insert = true;
            }
            
            list.add(intervals[i]);
        }

        if (!insert){
            list.add(newInterval);
        }

        int[][] interVals = list.toArray(new int[list.size()][]);

        int firstStart = interVals[0][0];
        int firstEnd = interVals[0][1];
        ArrayList<int[]> l = new ArrayList<>();

        for (int i = 1; i < interVals.length; i++){

            int secondStart = interVals[i][0];
            int secondEnd = interVals[i][1];

            if (firstEnd >= secondStart){
                firstStart = firstStart;
                firstEnd = Math.max(firstEnd, secondEnd);
                continue;
            }

            l.add(new int[]{firstStart, firstEnd});
            firstStart = secondStart;
            firstEnd = secondEnd;
        }

        l.add(new int[]{firstStart,firstEnd});

        return l.toArray(new int[l.size()][]);
    }
}