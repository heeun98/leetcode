class Solution {
    public int solution(int n, int k) {

        String convert = Integer.toString(n, k);
        
        String[] numbers = convert.split("0");
        int count = 0;
        
        for (String num : numbers) {
            if (num.isEmpty()) continue;
            long num1 = Long.parseLong(num);
            
            if (isSosu(num1)) count++;
        }
        return count;
    }
    
    private boolean isSosu(long num) {
        
        if (num == 1 || num == 0) return false;
        
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}