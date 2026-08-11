import java.util.*;

class Solution {
    
    int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
       
        for (int[] cost : costs) {
            pq.add(cost);
        }
        
        int sum = 0;
        
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int from = poll[0];
            int to = poll[1];
            int weight = poll[2];
            
            if (find(from) == find(to)) continue;
            
            sum += weight;
            union(from, to);
        }
        
        
        return sum;
    }
    
    public void union(int from , int to) {
        
        int a = find(from);
        int b = find(to);
        
        parents[a] = b;
    }
    
    public int find(int num) {
        
        if (num == parents[num]) {
            return num;
        }
        
        return parents[num] = find(parents[num]);
        
        
    }
}