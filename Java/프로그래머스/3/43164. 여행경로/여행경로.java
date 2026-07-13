import java.util.*;
import java.util.stream.*;

class Solution {
    
    boolean flag = false;
    List<String> answer = new ArrayList<>();
    public String[] solution(String[][] tickets) {
     
        
        List<String[]> gr = new ArrayList<>();
        
        for (int i = 0; i < tickets.length; i++) {
            gr.add(tickets[i]);
        }
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            
            return a[1].compareTo(b[1]);
        });
        
        boolean[] visit = new boolean[tickets.length];
        
        answer.add("ICN");
        dfs(0, tickets, visit, "ICN");
        
        return answer.stream().toArray(String[]::new);
    }
    
    public void dfs(int depth, String[][] tickets, boolean[] visit, String position) {
        
        if (depth == tickets.length) {
            flag = true;
            return;
        }
        
        
        for (int i = 0; i < tickets.length; i++) {
            
            String to = tickets[i][0];
            String from = tickets[i][1];
            
            if (visit[i]) continue;
            
            if (!to.equals(position)) continue;
            
            visit[i] = true;
            answer.add(from);
          
            dfs(depth + 1, tickets, visit, from);
            if (flag) return;
            visit[i] = false;
            answer.remove(answer.size() - 1);
        }
        
        
    }
}