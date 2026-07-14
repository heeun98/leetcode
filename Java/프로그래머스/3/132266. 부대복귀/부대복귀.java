import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
       
        int[] answer = new int[sources.length]; 
        int[] distance = new int[n + 1];
        
        Arrays.fill(distance, -1);
        
        List<List<Integer>> gr = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<>());
        }
        
        for (int[] node : roads) {
            int from = node[0];
            int to = node[1];
            
            gr.get(from).add(to);
            gr.get(to).add(from);
        }
        
        
        Queue<Integer> que = new LinkedList<>();
        que.add(destination);
        boolean[] visit = new boolean[n + 1];
        visit[destination] = true;
        int dis = 0;
        
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0 ; i < size; i++) {
                int now = que.poll();
                distance[now] = dis;
                for (int j = 0; j < gr.get(now).size(); j++) {
                    int next = gr.get(now).get(j);
                    
                    if (visit[next]) continue;
                    
                    visit[next] = true;
                    que.add(next);
                }
            
            }            
            dis++;
        }
        
        for (int i = 0; i < sources.length; i++) {
            int index = sources[i];
            answer[i] = distance[index];
        }
        
    
            
        return answer;
    }
}