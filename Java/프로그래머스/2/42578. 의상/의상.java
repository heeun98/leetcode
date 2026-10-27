import java.util.*;


class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            
            String name = cloth[0];
            String type = cloth[1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        
        int result = 1;
        for (String key : map.keySet()) {
            
            System.out.println(map.get(key));
            result *= (map.get(key) + 1);
        }
        
        return result - 1;
    }
}