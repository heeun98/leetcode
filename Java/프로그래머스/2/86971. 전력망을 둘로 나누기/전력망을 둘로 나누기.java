import java.util.*;

class Solution {
    
    private int count = 0;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        boolean[] visit = new boolean[n + 1];
        List<List<Integer>> gr = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            gr.add(new ArrayList<>());
        }
        
        
        for (int[] w : wires) {
            int from = w[0];
            int to = w[1];
            
            gr.get(from).add(to);
            gr.get(to).add(from);
        }
        int result = Integer.MAX_VALUE;
        
        for (int[] remove : wires) {
            
            int from = remove[0];
            int to = remove[1];
            
            gr.get(from).remove((Integer) to);
            gr.get(to).remove((Integer) from);
            
            count = 1;
            visit = new boolean[n + 1];
            visit[1] = true;
            dfs(gr, visit, 1);
            
            gr.get(from).add(to);
            gr.get(to).add(from);
            
            int remain = n - count;
            
            result = Math.min(result, Math.abs(count - remain));
            
        }
        
        return result;
    }
    
    
    public void dfs(List<List<Integer>> gr, boolean[] visit, int node) {
        
        for (int i = 0; i < gr.get(node).size(); i++) {
            int end = gr.get(node).get(i);            
            if (visit[end]) continue;
            
            count++;
            visit[end] = true;
            dfs(gr, visit, end);
        }
        
        
        
        
    }
}