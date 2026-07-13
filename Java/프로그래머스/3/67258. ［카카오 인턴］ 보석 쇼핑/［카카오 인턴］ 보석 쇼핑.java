import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        int size = new HashSet<>(Arrays.asList(gems)).size();
        
        Map<String, Integer> map = new HashMap<>();
        
        int[] answer = new int[]{1, gems.length};
        int left = 0;
        
        for (int right = 0; right < gems.length; right++) {
            
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            
            while (map.get(gems[left]) > 1) {
                map.put(gems[left], map.get(gems[left]) - 1);
                left++;
            }
            
            if (map.size() == size) {
                if (right - left < answer[1] - answer[0]) {
                    answer = new int[]{left + 1, right + 1};
                }
            }
        }
        
        return answer;
    }
}