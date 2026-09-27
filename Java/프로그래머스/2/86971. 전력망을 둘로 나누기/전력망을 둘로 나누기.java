import java.util.*;

class Solution {
    
    private int count = 0;
    private int result = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        
        boolean[] visit = new boolean[n + 1];
        
        List<List<Integer>> gr = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<>());
        }
        
        
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            gr.get(from).add(to);
            gr.get(to).add(from);
        }
        
        
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            count = 1;
            visit = new boolean[n + 1];
            gr.get(from).remove((Integer) to);
            gr.get(to).remove((Integer) from);
            
            visit[1] = true;
            dfs(gr, visit, 1);
            
            result = Math.min(result, Math.abs((n - count) - count));
            
            gr.get(from).add(to);
            gr.get(to).add(from);
        }
        
        return result;
    }
    
    
    private void dfs(List<List<Integer>> gr, boolean[] visit, int node) {
        
        
        for (int i = 0; i < gr.get(node).size(); i++) {
            
            int next = gr.get(node).get(i);
            if (visit[next]) continue;
            
            visit[next] = true;    
            count++;
            dfs(gr, visit, next);
        
        }
        
        
    }
}