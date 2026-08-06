class Solution {
    
    boolean[] visit;
    int result = Integer.MAX_VALUE;
    boolean flag = false;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        
        visit = new boolean[words.length];
        dfs(0, begin, target, words);
        
        if (!flag) {
            return 0;
        } else {
            return result;
        }
    
    }
    
    
    public void dfs(int depth, String begin, String target, String[] words) {
        
        if (begin.equals(target)) {
            flag = true;
            result = Math.min(result, depth);
            return;
        }
        
     
        for (int i = 0; i < words.length; i++) {
            if (!canSwitch(begin, words[i])) continue;
            if (visit[i]) continue;
            
            visit[i] = true;
            dfs(depth + 1, words[i], target, words);
            visit[i] = false;
        }
        
    }
    
    
    private boolean canSwitch(String to, String from) {
        
        int count = 0;
        for (int i = 0; i < to.length(); i++) {
            if ((to.charAt(i) == from.charAt(i))) {
                continue;
            }
            count++;
            
            if (count >= 2) return false; 
        }
        
        return true;
    } 
}