import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        int count = 0;
        while (pq.size() >= 2) {
            
            int min = pq.peek();
            
            if (min >= K) {
                return count;
            }
            
            int pollA = pq.poll();
            int pollB = pq.poll();
            
            int newNum = pollA + (pollB * 2);
            pq.offer(newNum);
            count++;
        }
        
        if (pq.peek() >= K) return count;
        
        return -1;
    }
}