import java.util.*;

class Solution {
    
    int[] dr = {0, 1};
    int[] dc = {1, 0};
    
    static final int mod = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        
        
        boolean[][] waters = new boolean[n][m];
        
        for (int i = 0; i < puddles.length; i++) {
            int[] water = puddles[i];
            int col = water[0];
            int row = water[1];
            waters[row - 1][col - 1] = true;
        }
        
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (waters[i][j]) continue;
                if (i == 0 && j == 0) continue;
                
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] % mod;
                    continue;
                }
                
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] % mod;
                    continue;
                }
                
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
            }
        }
        
        return dp[n - 1][m - 1] % mod;
        
    }
}