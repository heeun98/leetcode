import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int[] nums = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            nums[i] = number.charAt(i) - '0';
        }
        
        
        Stack<Integer> st = new Stack<>();
        int cnt = 0;
        
        for (int i = 0 ; i < nums.length; i++) {
            
            if (st.isEmpty()) {
                st.push(nums[i]);
                continue;
            }
            
            
            while (!st.isEmpty() && st.peek() < nums[i] && cnt < k) {
                st.pop();
                cnt++;
            }
            
            st.push(nums[i]);
        }
        
        
        while (cnt < k) {
            st.pop();
            cnt++;
        }
        
        
        List<Integer> result = new ArrayList<>(st);
        
        StringBuilder sb = new StringBuilder();
        for (int n : result) {
            sb.append(n);
        }
        
        return sb.toString();
    }
}