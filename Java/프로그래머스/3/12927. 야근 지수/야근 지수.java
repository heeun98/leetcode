import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        
        
        for (int num : works) {
            pq.add(num);
        }
        
        for (int i = 0; i < n; i++) {
            int poll = pq.poll() - 1;
            if (poll < 0) break;
            pq.add(poll);
        }
        
        long sum = 0L;
        while (!pq.isEmpty()) {
            int nums = pq.poll();
            sum = sum + (nums * nums);
        }
        
        return sum;
    }
}