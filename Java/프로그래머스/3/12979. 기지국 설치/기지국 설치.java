class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int endPoint = 0;
        int result = 0;
        for (int station : stations) {
            
            int start = station - w;
            int end = station + w;
            int range = start - endPoint - 1;
            
            if (range > 0) {
                result +=  (range + 2 * w) / (2 * w + 1);
            }
            if (end >= n) {
                endPoint = n;
            } else {
                endPoint = end;
            }
        }
        
        int finalGap = n - endPoint;
        
        if (finalGap > 0) result += (finalGap + 2 * w) / (2 * w + 1);
        return result;
    }
}