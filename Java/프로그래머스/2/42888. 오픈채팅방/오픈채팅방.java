import java.util.*;


class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        
        
        for (String r : record) {
            
            if (r.split(" ")[0].equals("Leave")) continue;
            
            String id = r.split(" ")[1];
            String name = r.split(" ")[2];
            
            user.put(id, name);
        }
    
        
        List<String> result = new ArrayList<>();
        
        for (String r : record) {
            
            String op = r.split(" ")[0];
            String id = r.split(" ")[1];
            String name = user.get(id);
            
            if (op.equals("Enter")) {
                result.add(name + "님이 들어왔습니다.");
            } else if (op.equals("Leave")) {
                result.add(name + "님이 나갔습니다.");     
            }
        }
        
            
        return result.stream().map(i -> i).toArray(size -> new String[size]);
  
    }
}