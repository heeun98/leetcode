import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
      
        long lo = 1;
        long hi = (long)1_000_000_000 * 100_000;
        
        while (lo < hi) {
            
            long mid = (lo + hi) / 2;
            
            if (predicate(mid, n, times)) hi = mid;
            else lo = mid + 1;
            
        }
        return lo;
    }
    
    
    public boolean predicate(long mid, int n, int[] times) {
        
        long sum = 0;
        for (int i = 0; i < times.length; i++) {
            sum += (mid / times[i]);
        }
        
        if (sum >= n) return true;
        return false;
    }
}