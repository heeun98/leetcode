import java.util.*;
import java.util.stream.*;


class Solution {
    public int solution(int[] A, int[] B) {
        
        
        Arrays.sort(A);
        
        Arrays.sort(B);
        
        
        int idx1 = 0;
        int idx2 = 0;
        int sum = 0;
        
        while (idx2 < B.length && idx1 < A.length) {
            
            while (idx2 < B.length && A[idx1] >= B[idx2]) {
                idx2++;
            }
            
            if (idx2 >= B.length) break;

            if (A[idx1] < B[idx2]) {
                sum++;
                idx1++;
                idx2++;
                continue;
            }
                 
        }
        
        return sum;
    }
}