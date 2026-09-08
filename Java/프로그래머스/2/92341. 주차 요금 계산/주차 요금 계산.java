import java.util.*;


class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<Integer, Integer> inMap = new HashMap<>();
        Map<Integer, Integer> result = new TreeMap<>();
        
        
        for (int i = 0; i < records.length; i++) {
            
            String input = records[i];
            String[] ins = input.split(" ");
            
            String time = ins[0];
            String number = ins[1];
            String op = ins[2];
            
            int realTime = parseToNumber(time);
            int realNumber = Integer.parseInt(number);
            
            if (op.equals("IN")) {
                inMap.put(realNumber, realTime);
                
            } else {
                int inputTime = inMap.get(realNumber);
                inMap.remove(realNumber);
                int disTime = realTime - inputTime;
                
                result.put(realNumber, result.getOrDefault(realNumber, 0) + 
                           disTime);
            }
            
        }
        
        for (int key : inMap.keySet()) {
            int carTime = inMap.get(key);
            int outTime = 23 * 60 + 59;
            
            int remain = outTime - carTime;
            
            result.put(key, result.getOrDefault(key, 0) + 
                           remain);
        }
        
        
        for (int key : result.keySet()) {
            int totalTime = result.get(key);
            
            int fee = fees[1];
            
            if (totalTime > fees[0]) {
            int diff = totalTime - fees[0];
            fee += (int) Math.ceil((double) diff / fees[2]) * fees[3];
        }
            
            result.put(key, fee);
        }
        
        
        int size = result.size();
        
        int[] answer = new int[size];
        
        int idx = 0;
        for (Integer key : result.keySet()) {
            int v = result.get(key);
            answer[idx] = v;
            idx++;
        }
        
        return answer;
    }
    
    private int parseToNumber(String time) {
        
        String[] tmp = time.split(":");
        
        String hour = tmp[0];
        String minute = tmp[1];
        
        
        return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }
}