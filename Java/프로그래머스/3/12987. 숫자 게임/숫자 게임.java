import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = -1;
        
        Arrays.sort(A); // 7 5 3 1
        Arrays.sort(B); // 8 6 2 2
        int point = 0;
        int i = A.length - 1;
        int j = B.length - 1; 
        
        while(i >= 0) {
            if (A[i] < B[j]) {
                point++;
                i--;
                j--;
            } else {
                i--;
            }
        }
        
        return point;
    }
}