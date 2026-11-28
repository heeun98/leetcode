import java.util.*;

class Solution {
    
    private Set<Integer> uniqueNum = new HashSet<>();
    private int count = 0;
    public int solution(String numbers) {
        String[] nums = numbers.split("");
        boolean[] visit = new boolean[nums.length];
        
        
        dfs(0, nums, visit, "");
        

        return uniqueNum.size();
    }
    
    public void dfs(int v, String[] nums, boolean[] visit, String s) {
        if (v == nums.length) return;
        
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            if (isSosu(s + nums[i]))  {
                uniqueNum.add(Integer.parseInt(s + nums[i]));
            }
            dfs(v + 1, nums, visit, s + nums[i]);
            visit[i] = false;
        }
    }
    
    public boolean isSosu(String num) {
        int n = Integer.parseInt(num);
        
        if (n == 0) return false;
        if (n == 1) return false;

        
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}