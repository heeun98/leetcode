import java.util.*;


class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int row = money.length;
        int[][] dp = new int[row][n + 1];
             
        Arrays.sort(money);
        int min = money[0];
    
        for (int i = 0; i <= n; i = i + min) {
            dp[0][i] = 1;
        }
        
        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= n; j++) {
                
                if (j - money[i] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - money[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
                          
        
     
                                                
        
        return dp[dp.length - 1][n];
    }
}