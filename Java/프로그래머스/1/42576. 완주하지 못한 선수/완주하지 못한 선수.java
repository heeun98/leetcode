import java.util.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        
        
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        
        for (String name : completion) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) - 1);
            }
            
            if (map.get(name) == 0) {
                map.remove(name);
            }
        }
        
        String answer = null;
        
        for (String name : map.keySet()) {
            answer = name;
        }
        
        return answer;
        
    }
}