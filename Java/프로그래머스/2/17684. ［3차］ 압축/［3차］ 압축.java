import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        List<Integer> result = new ArrayList<>();
        
        List<String> dic = new ArrayList<>();
        char start = 'A';
        for (int i = 0; i < 26; i++) {
            dic.add(String.valueOf(start));
            start++;
        }
        
        
        System.out.println(dic);
        
        for (int i = 0; i < msg.length(); i++) {
            
            String tmp = String.valueOf(msg.charAt(i));
            
            while (i < msg.length() - 1 && dic.contains(tmp)) {
                i++;
                if (dic.contains(tmp + msg.charAt(i))) {
                    tmp += msg.charAt(i);
                } else {
                    i--;
                    break;
                }
            }
            
            
            int idx = dic.indexOf(tmp);
            result.add(idx + 1);
            
            if (i >= msg.length() - 1) break;
            dic.add(tmp + msg.charAt(i + 1));
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}