import java.util.*;
import java.util.stream.*;

// n : 셔틀 운행 횟수
// t : 셔틀 운행 간격
// m : 한 셔틀에 탈 수 있는 최대 크루 수
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        
        int limit = 9 * 60;
        
        int[] times = Arrays.stream(timetable)
            .mapToInt(i -> parseToMinute(i))
            .toArray();
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        
        for (int e : times) {
            pq.add(e);
        }
        
        // 9 : 00, 9 : 10, 9 : 20, 
        
        for (int i = 0; i < n - 1; i++) { // n - 1회 만큼 수행
            if (i != 0) {
                limit = limit + t;
            }
            for (int j = 0; j < m; j++) { // m 회 만큼 수행
                
                if (!pq.isEmpty() && limit >= pq.peek()) {
                    pq.poll();
                } else {
                    break;
                }
                
            }
        }
        
        if (n > 1) {
            limit += t;
        }
        int board = 0;
        int last = 0;
        for (int i = 0; i < m; i++) {
            
            if (!pq.isEmpty() && pq.peek() <= limit) {
                last = pq.poll();
                board++;
            } else {
                break;
            }
            
        }
        
    
        int result;
        if (board < m) {
            result = limit;               
        } else {
            result = last - 1;
        }

        answer = String.format("%02d:%02d", result / 60, result % 60);
        
        return answer;
    }
    
    
    public int parseToMinute(String time) {
        
        
        String[] times = time.split(":");
        int result = 0;
        
        
        int t1 = Integer.parseInt(times[0]) * 60;
        int t2 = Integer.parseInt(times[1]);
        
        
        result = t1 + t2;
        
        return result;
        
    }
}
