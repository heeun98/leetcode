import java.util.*;

class Solution {
    public int[] solution(String msg) {
                
        List<String> list = new ArrayList<>();
        
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            list.add(String.valueOf(c));
            c++;
        }
        
        System.out.println(list);
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            String plus = String.valueOf(ch);
            for (int j = i + 1; j < msg.length(); j++) {
                if (!list.contains(plus + msg.charAt(j))) {
                    break;
                } 
                
                i = j;
                plus = plus + msg.charAt(j);
            }
            
            int index = list.indexOf(plus) + 1;
            result.add(index);
            
            if (i + 1 >= msg.length()) break;
            list.add(plus + msg.charAt(i + 1));
           
            
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}