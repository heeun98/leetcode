class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[][] dp = new long[n][2];
       

        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];
        long answer = Math.max(dp[0][0], dp[0][1]);

        for (int i = 1; i < n; i++) {
            dp[i][0] = sequence[i] + Math.max(0, dp[i - 1][1]);
            dp[i][1] = -sequence[i] + Math.max(0, dp[i - 1][0]);
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }
        return answer;
    }
}