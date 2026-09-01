import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> gr = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            int from = e[0];
            int to = e[1];
            gr.get(from).add(to);
            gr.get(to).add(from);
        }
        
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> que = new LinkedList<>();
        visit[1] = true;
        que.offer(1);
        int dis = 0;
      
        int count = 0;
        boolean flag = false;
        
        while (!que.isEmpty()) {
            int size = que.size();
          
            for (int i = 0; i < size; i++) {
                int now = que.poll();
                List<Integer> tmp = gr.get(now);
                flag = false;
                
                for (int j = 0; j < tmp.size(); j++) {
                    int next = tmp.get(j);
                    if (visit[next]) continue;
                    visit[next] = true;
                    que.offer(next);
                }
            }
            dis++;
        }
        
        que = new LinkedList<>();
        visit = new boolean[n + 1];
        visit[1] = true;
        que.offer(1);
        int dis1 = 0;
        count = 0;
        
        while (!que.isEmpty()) {
            int size = que.size();
          
            for (int i = 0; i < size; i++) {
                int now = que.poll();
                if (dis1 == dis - 1) count++;
                List<Integer> tmp = gr.get(now);
                flag = false;
                
                for (int j = 0; j < tmp.size(); j++) {
                    int next = tmp.get(j);
                    if (visit[next]) continue;
                    visit[next] = true;
                    que.offer(next);
                }
            }
            dis1++;
        }
        
        return count;
    }
}