import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int totalJob = jobs.length;
        
        
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[2] - o2[2];
                
            }
        );
        int idx = 0;
        int endTime = jobs[0][0];
        int sum = 0;
        int done = 0;
        
        while (done < totalJob) {
            
            while (idx < totalJob && jobs[idx][0] <= endTime) {
                int arrive = jobs[idx][0];
                int duration = jobs[idx][1];
                int index = idx;
                pq.offer(new int[]{arrive, duration, index});
                idx++;
            }
            
            if (idx < totalJob && pq.isEmpty()) {
                pq.offer(new int[]{jobs[idx][0], jobs[idx][1], idx});
                idx++;
            }
            
            int[] poll = pq.poll(); // 작업 시작
            int arr = poll[0];
            int dur = poll[1];
            if (arr > endTime) {
                endTime = arr + dur;
            } else {
                endTime = endTime + dur;
            }
            sum += (endTime - arr);
            System.out.println(sum);
            done++;
        }
        
        // 18 - 2 = 17 + 7 + 3 = 27 
        // 12 - 1 == 7
        // 3
        // 30
        
        return sum / jobs.length;
    }
}