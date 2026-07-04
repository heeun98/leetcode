import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String str : operations) {
            String[] cal = str.split(" ");
            
            String op = cal[0];
            int num = Integer.parseInt(cal[1]);
            
            if (op.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                continue;
            }
            if (map.isEmpty()) continue;
            
            if (num == 1) {
                map.pollLastEntry();
                continue;
            }
            
            if (num == -1) {
                map.pollFirstEntry();
                continue;
            }
            
        }
        
        
        if (map.isEmpty()) {
            return new int[]{0, 0};
        } else {
            int max = map.lastKey();
            int min = map.firstKey();
            return new int[]{max, min};
        }
    }
}