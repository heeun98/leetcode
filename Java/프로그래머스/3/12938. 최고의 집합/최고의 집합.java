import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        
        int num = s / n;
        int remain = s % n;
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = num;
        }
        int idx = result.length - 1;
        
        
        while (remain != 0) { 
           result[idx] = result[idx] + 1;
           remain--;
            idx--;
        }
  
        return result;
    }
}