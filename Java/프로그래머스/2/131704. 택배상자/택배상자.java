import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        int size = order.length;
        Stack<Integer> st = new Stack<>();
        int i = 1;
        int count = 0;
        
        while (order[0] >= i) {
            st.push(i);
            i++;
        }
        
        
        for (int j = 0; j < order.length; j++) {
            
            
            while (order[j] > i) {
                st.push(i);
                i++;
            }
            
             if (order[j] == i) {
                i++;
                count++;
                continue;
            }
            
            if (!st.isEmpty() && order[j] == st.peek()) {
                st.pop();
                count++;
                continue;
            }
            
            break;
        }
        
        return count;
        
        
    }
}