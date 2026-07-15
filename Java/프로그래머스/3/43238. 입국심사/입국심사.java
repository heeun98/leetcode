import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long lo = 0L;
        long hi = (long) Arrays.stream(times).max().getAsInt() * n;
        
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            
            if (isPossible(mid, times, n)) hi = mid;
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    public boolean isPossible(long total, int[] times, int n) {
        long sum = 0;
        for (int time : times) {
            sum += (total / time);
            if (sum >= n) return true;
        }
        return false;
    }
}