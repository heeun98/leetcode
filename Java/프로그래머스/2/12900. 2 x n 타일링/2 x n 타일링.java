import java.util.*;

class Solution {
    
    private int DIV = 1_000_000_007;
    
    public int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = dp[0] + dp[1];
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % DIV;
        }
        
        return dp[n];
    }
}