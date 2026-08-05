import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int result = Integer.MIN_VALUE;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            
            for (int j = 0; j < i + 1; j++) {
                
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                    continue;
                }
                
                
                if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                    continue;
                }
                
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);

                result = Math.max(result, dp[i][j]);

            } 
        }
        
      
        return result;
    }
}