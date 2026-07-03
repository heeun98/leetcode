import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
    
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); //         최대힙
        
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        for (int i = 0; i < n; i++) {
            int num = pq.poll();
            if (num == 0) return 0L;
            num--;
            pq.add(num);
        }
        
        List<Integer> result = new ArrayList<>(pq);
        Long sum = 0L;
        for (int i = 0; i < result.size(); i++) {
            int number = result.get(i);
            sum += (number * number);
        }
        
        return sum;
       
    }
}