class Solution {
    
    private int div = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
       
        int[][] dp = new int[n][m];
        
        for (int[] point : puddles) {
            int r = point[0];
            int c = point[1];
            
            dp[c - 1][r - 1] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            
            if (dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        
        for (int i = 0; i < m; i++) {
            if (dp[0][i] == -1) break;
            dp[0][i] = 1;
        }
        
        
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == -1) continue;
                
                if (dp[i - 1][j] == -1) {
                    dp[i][j] = dp[i][j - 1] % div;
                    continue;
                }
                
                if (dp[i][j - 1] == -1) {
                    dp[i][j] = dp[i - 1][j] % div;
                    continue;
                }
                
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % div;
            }
        }
        
        
        return dp[n - 1][m - 1] % div;
    }
}


/**
dp 를 초기화
dp 에서 puddles 는 -1 으로 
dp에서 1열과 1행은 모두 1로 초기화
dp[i][j] = dp[i - 1][j] + dp[i][j - 1]


**/