import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        boolean[] visit = new boolean[n];
        
        List<List<Integer>> gr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (j == i) continue;
                
                if (computers[i][j] == 1) {
                    gr.get(i).add(j);
                    gr.get(j).add(i);
                }
                
            }
        }
        
        
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            dfs(i, visit, gr);
            count++;
        }
        return count;
       
    }
    
    
    public void dfs(int n, boolean[] visit, List<List<Integer>> gr) {
        
        for (int i = 0; i < gr.get(n).size(); i++) {
            int node = gr.get(n).get(i);
            if (visit[node]) continue;
            
            visit[node] = true;
            dfs(node, visit, gr);
        }
    }
}