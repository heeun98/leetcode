import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
        int last = routes[0][1];
        int cnt = 1;
        
        for (int i = 1; i < routes.length; i++) {
            int[] poll = routes[i];
            
            int first = poll[0];
    
            if (first <= last) {
                last = Math.min(last, poll[1]);
            } else {
                cnt++;
                last = poll[1];
            }
        }
        
        return cnt;
    }
}