import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        int count = 0;
        while (!pq.isEmpty() && pq.peek() < K) {
            
            if (pq.size() < 2) {
                return -1;
            }
            int pollA = pq.poll();
            int pollB = pq.poll();
            
            int newE = pollA + pollB * 2;
            pq.add(newE);
            count++;
        }
        
        
        
        return count;
    }
}