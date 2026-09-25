import java.util.*;


class Solution {
    
    private Set<Integer> set = new HashSet<>();
    private int count = 0;
    
    public int solution(String numbers) {
        int answer = 0;
        
        char[] nums = numbers.toCharArray();
        boolean[] visit = new boolean[nums.length];
        
        
        dfs(nums, visit, "");
        
        
        return count;
    }
    
    private void dfs(char[] nums, boolean[] visit, String n) {
        
        if (!n.isEmpty() && isSosu(n)) {
            set.add(Integer.parseInt(n));
            System.out.println(n);
            count++;
        }
        
        for (int i = 0; i < nums.length; i++) {
            
            if (visit[i]) continue;
            visit[i] = true;
            dfs(nums, visit, n + nums[i]);
            visit[i] = false;
        }
        
        
    }
    
    
    private boolean isSosu(String num) {
        
        
        int n = Integer.parseInt(num);
        if (set.contains(n)) return false;
        if (n == 1 || n == 0) return false;
        
        if (n == 2) return true;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}