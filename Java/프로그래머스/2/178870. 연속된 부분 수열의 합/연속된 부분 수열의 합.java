class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = null;
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int min = Integer.MAX_VALUE;
        
        while (left < sequence.length || right < sequence.length) {
            
            
            if (sum < k && right == sequence.length - 1) break;
            
            
            if (sum < k) {
                right++;
                sum += sequence[right];
            } else if (sum > k) {
                sum -= sequence[left];
                left++;
            } else {
                if (min > right - left - 1) {
                    min = right - left - 1;
                    answer = new int[]{left, right};

                }
                
                if (right == sequence.length - 1) break;
                sum -= sequence[left];
                left++;
                right++;
                sum += sequence[right];
                
                
            }
            
        
        }
        
        
        return answer;
    }
}