import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] remains = new int[progresses.length];
        int max = remains[0];
        int count = 0;
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            remains[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            if (remains[i] > max) {
                if (count > 0) result.add(count);
                max = remains[i];
                count = 1;
            } else {
                count++;
            }
        }
        
        
        
        result.add(count);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}



/**

100 - 30 + 29 = 99 / 30 = 3;

100 - 93 + 94 = 101

7, 3, 9

max = 7;
max < arr[i] -> count = 2


**/