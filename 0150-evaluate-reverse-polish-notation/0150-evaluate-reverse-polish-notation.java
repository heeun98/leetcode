import java.util.*;

class Solution {

    List<String> list = List.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String ch = tokens[i];

            // 숫자인지 연산자인지 어케알지

            if (!list.contains(ch)) {// 연산자 아님, 숫자임
                int num = Integer.parseInt(ch);
                st.push(num);
            } else { // 연산자임
                int first = st.pop();
                int second = st.pop();

                System.out.println(first + " : " + second);
                int idx = list.indexOf(ch);
                String op = list.get(idx);
                int input = 0;

                if (op.equals("*")) {
                    input = first * second;
                } else if (op.equals("-")) {
                    input = second - first;
                } else if (op.equals("+")) {
                    input = first + second;
                } else {
                    input = second / first;
                }
                st.push(input);
            }  
        }

        return st.pop();
    }
}