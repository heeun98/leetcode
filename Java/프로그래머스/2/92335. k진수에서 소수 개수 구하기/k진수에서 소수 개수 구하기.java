class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        
        String result = Integer.toString(n, k);
        int count = 0;
        String[] nums = result.split("0+");
        
        for (String s : nums) {
            if (s.isEmpty()) continue;
            long number = Long.parseLong(s);
            
            if (isSosu(number)) {
                count++;
            }
            
        }
        return count;
    }
    
    private boolean isSosu(long number) {
        if (number < 2) return false;
        
        
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
        
    }
}