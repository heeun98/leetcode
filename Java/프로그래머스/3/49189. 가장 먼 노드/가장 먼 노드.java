import java.util.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
                
        List<List<Integer>> gr = new ArrayList<>();
        
        for (int i = 0 ; i <= n; i++) {
            gr.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];
            
            gr.get(from).add(to);
            gr.get(to).add(from);
        }
        
        
        Queue<Integer> que = new LinkedList<>();
        
        boolean[] visit = new boolean[n + 1];
        
        que.add(1);
        visit[1] = true;
        int answer = 0;
        int dis = 0;
        
        while (!que.isEmpty()) {
            int size = que.size();
            if (size > 0) {
                answer = size;
            }
            
            for (int i = 0; i < size; i++) {
                int now = que.poll();
                
                for (int j = 0; j < gr.get(now).size(); j++) {
                    
                    int next = gr.get(now).get(j);
                    
                    if (visit[next]) continue;
                    
                    visit[next] = true;
                    que.offer(next);
                }
            }
            dis++;
        }
        
        return answer;
        
        
    }
    

}