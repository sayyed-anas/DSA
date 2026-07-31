class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int firstStart = intervals[0][0];
        int firstEnd = intervals[0][1];

        ArrayList<int[]> res = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++){

            int secondStart = intervals[i][0];
            int secondEnd = intervals[i][1];

            if (firstEnd >= secondStart){
                firstStart = firstStart;
                firstEnd = Math.max(firstEnd, secondEnd);
                continue;
            }

            res.add(new int[]{firstStart, firstEnd});
            firstStart = secondStart;
            firstEnd = secondEnd;
        }

        res.add(new int[]{firstStart, firstEnd});
        return res.toArray(new int[res.size()][]);
    }
}