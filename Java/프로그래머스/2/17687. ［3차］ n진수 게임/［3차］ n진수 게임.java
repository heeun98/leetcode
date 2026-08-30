class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String result = "";
        
        for (int i = 0; i < t * m; i++) {
            
            String tmp = Integer.toString(i, n);
            answer += tmp;
        
        }
        
        
        for (int i = 0; i < answer.length(); i++) {
             if (i % m == p - 1) {
                result += answer.charAt(i);
            }
        }
        
        
        
        return result.toUpperCase().substring(0, t);
    
    }
}