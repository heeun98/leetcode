import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        
        Stack<Integer> st = new Stack<>();
        st.push(prices[0]);
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            
            if (!st.isEmpty() && st.peek() >= prices[i]) {
                st.push(prices[i]);
                continue;
            }

            if (!st.isEmpty() && st.peek() < prices[i]) {
                int price = st.peek();
                result += prices[i] - price;
                st.push(prices[i]);
            }
        }

        return result;
    }
}