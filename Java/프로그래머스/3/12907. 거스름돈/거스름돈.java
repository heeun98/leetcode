import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        
        int answer = 0;
        int kind = money.length;
        int[][] dp = new int[kind][n + 1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        
        
        Arrays.sort(money);
        int min = money[0];
        dp[0][0] = 1;
        
        for (int i = min; i <= n; i++) {
            dp[0][i] = dp[0][i - min];
        }
        
      
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                
                
                if (j - money[i] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - money[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                
                
            }
        }
        
      
        
        
        return dp[dp.length - 1][dp[0].length - 1];
    }
}