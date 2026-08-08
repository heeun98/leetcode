import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
        int finalEnd = routes[0][1];
        
        int count = 0;
        
        for (int i = 1; i < routes.length; i++) {
            int start = routes[i][0];
            int end = routes[i][1];
            
            
            if (start <= finalEnd) {
                
                if (end <= finalEnd) {
                    finalEnd = end;
                } 
                
            } else {
                count++;
                finalEnd = end;
            }
        }
        return count + 1;
    }
}