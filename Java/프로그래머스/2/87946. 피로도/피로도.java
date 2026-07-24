class Solution {
    
    private int max = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        int len = dungeons.length;
        boolean[] visit = new boolean[len];
        
        dfs(0, 0, visit, dungeons, k);
        return max;
    }
    
    private void dfs(int depth, int idx, boolean[] visit, 
                    int[][] dungeons, int remain) {
        
        max = Math.max(depth, max);
        
                
        for (int i = 0; i < dungeons.length; i++) {
            
            int require = dungeons[i][0];
            int acquire = dungeons[i][1];
            if (remain < require) continue;
            if (visit[i]) continue;
            
            visit[i] = true;
            dfs(depth + 1, i, visit, dungeons, remain - acquire);
            visit[i] = false;
        }
        
    }
}