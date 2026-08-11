import java.util.*;


class Solution {
    
    int[] parents;
    public int solution(int n, int[][] costs) {
    
        parents = new int[n];
        
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        int result = 0;
        for (int[] cost : costs) {
            
            int to = cost[0];
            int from = cost[1];
            int weight = cost[2];
            
            if (find(to) == find(from)) continue;
            
            union(to, from);
            result += weight;
        }
        
        return result;
    }
    
    public int find(int num) {
        
        if (num == parents[num]) {
            return num;
        }
        
        return parents[num] = find(parents[num]);
    }
            
    public void union(int to, int from) {
        
        int a = find(to);
        int b = find(from);
        
        parents[a] = b;
    }
}