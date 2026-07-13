import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        
        
        List<int[]>[] gr = new ArrayList[n];
        boolean[] visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            gr[i] = new ArrayList<>();
        }
        
        for (int[] c : costs) {
            int start = c[0];
            int end = c[1];
            int cost = c[2];
            
            gr[start].add(new int[]{end, cost});
            gr[end].add(new int[]{start, cost});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        pq.add(new int[]{0, 0});
        int sum = 0;
        while (!pq.isEmpty()) {
            
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];
            
            if (visit[node]) continue;
            
            visit[node] = true;
            sum += cost;
            
            for (int[] next : gr[node]) {
                pq.add(next);
            }
            
        }
        
        return sum;
    }
}