import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int canGet = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        
        for (int n : nums) {
            set.add(n);
        }
        
        return canGet < set.size() ? canGet : set.size();
    }
}