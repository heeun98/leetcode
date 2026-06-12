class Solution {
    public int jump(int[] nums) {
        
        int[] dp = new int[nums.length];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            // 1 to (0 + 2)
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {

                if (dp[j] > dp[i] + 1) {
                    dp[j] = dp[i] + 1;
                }
            }
        }


        return dp[nums.length - 1];

    }
}

/**

0 m m m m
0 1 1 m m
0 1 1 2 2
0 1 1 2 2

*/


/**

0 1 1
0

 */


// 10,000,000