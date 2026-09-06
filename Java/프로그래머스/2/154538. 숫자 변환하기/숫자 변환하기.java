import java.util.*;

class Solution {
    
    
    private int[] d = new int[3];
    public int solution(int x, int y, int n) {
        
        if (x == y) return 0;
        
        boolean[] visit = new boolean[y + 1];
        Queue<Integer> que = new LinkedList<>();
        int[] result = new int[y + 1];
        
        que.add(x);
        visit[x] = true;
        
        
        while (!que.isEmpty()) {
            
            int size = que.size();
            
            
            for (int i = 0; i < size; i++) {
                
                int cur = que.poll();
                
                for (int j = 0 ; j < 3; j++) {
                    int next = 0;
                    if (j == 0) {
                        next = cur * 2;
                    } else if (j == 1) {
                        next = cur * 3;
                    } else {
                        next = cur + n;
                    }
                    if (next > y) continue;
                    
                    if (visit[next]) continue;
                    
                    visit[next] = true;
                    result[next] = result[cur] + 1;
                    que.add(next);
                }
                
            }
            
            
        }
        if (result[y] == 0) return -1;
        
        return result[y];
    }
}