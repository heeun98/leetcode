import java.util.*;

class Solution {
    
    int n;
    int count = 0;
    int len;
    boolean visit[];
    Set<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        n = banned_id.length;
        len = user_id.length;
        int depth = 0;
        visit = new boolean[len];
        
    
        for (int i = 0 ; i < len; i++) {
            if (!isEqual(user_id[i], banned_id[depth])) continue;
            visit[i] = true;
            dfs(depth + 1, user_id, banned_id);
            visit[i] = false;
        }
        return set.size();
    }
    
    void dfs(int depth, String[] user_id, String[] banned_id) {
    
        
        if (depth == n) {
            set.add(Arrays.toString(visit));
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (visit[i]) continue;
            if (!isEqual(user_id[i], banned_id[depth])) continue;
                
            visit[i] = true;
            dfs(depth + 1, user_id, banned_id);
            visit[i] = false;
        }
        
    }
                
    boolean isEqual(String user, String banned) {
        
        if (user.length() != banned.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}