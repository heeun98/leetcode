class Solution {
    
    boolean[] visit;
    public int solution(int n, int[][] computers) {
        int count = 0;
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            dfs(n, computers, i);
            count++;
        }
        
        return count;
    }
    
    public void dfs(int n, int[][] computers, int idx) {
        
        
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            
            if (computers[idx][i] == 1) {
                visit[i] = true;
                dfs(n, computers, i);
            }
        }
        
    }
}