import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));


        int[] prev = intervals[0];

        List<int[]> result = new ArrayList<>();


        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] < intervals[i][0]) {
                result.add(prev);
                prev = intervals[i];
            } else {
                prev = new int[]{prev[0], Math.max(intervals[i][1], prev[1])};
            }
        }
        result.add(prev);


        return result.toArray(new int[result.size()][]);
    
    }
}


/**

    s   e
      s.        e
                    s.   e
                                    s.     e


 */


