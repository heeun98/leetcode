import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        
        int lo = 1;
        int hi = Arrays.stream(stones).max().getAsInt();
        // mid 는 건널 수 있는 사람 수
        int mid = (lo + hi) / 2;
        
        while (lo < hi) {
            
            mid = (lo + hi + 1) / 2;
            
            if (canCross(stones, mid, k)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }   
        }
        
        return lo;
    }
    
    private boolean canCross(int[] stones, int mid, int k) {
        
        int cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            
            if (stones[i] < mid) {
                cnt++;
                if (cnt >= k) return false;
            } else {
                cnt = 0;
            }
            
        }
        
        return true;
    }
}