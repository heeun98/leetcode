import java.util.*;


class Solution {
    public int solution(String dartResult) {
        int[] round = new int[3];
        String num = "";
        
        int idx = 0;
        
        for (char ch : dartResult.toCharArray()) {
            
            if (idx > 3) break;
            
            if (Character.isDigit(ch)) {
                num += ch;
                continue;
            }
            
            
            if (ch == 'S') {
                int n = Integer.parseInt(num);
                System.out.println(n);
                round[idx] = n; 
                idx++;
                num = "";
                continue;
                
                
            } else if (ch == 'D') {
                int n = Integer.parseInt(num);
                round[idx] = n * n;
                idx++;
                num = "";
                continue;
                
            } else if (ch == 'T') {
                int n = Integer.parseInt(num);
                round[idx] = n * n * n;
                idx++;
                num = "";
                continue;

            }
            
            if (ch == '*') {
                if (idx - 1 == 0) {
                    round[idx - 1] *= 2;
                } else {
                    round[idx - 1] *= 2;
                    round[idx - 2] *= 2;
                }
            } else if (ch == '#') {
                round[idx - 1] *= (-1);
            }
        
        }
        
        
        
        return round[0] + round[1] + round[2];
    }
}