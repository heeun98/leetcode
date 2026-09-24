class Solution {
    
    private final int SIZE = 600_000;
    public int solution(int[] queue1, int[] queue2) {
        
        
        int[] queueA = new int[SIZE];
        int[] queueB = new int[SIZE];
        
        for (int i = 0; i < queue1.length; i++) {
            queueA[i] = queue1[i];
        }
        
        for (int i = 0; i < queue1.length; i++) {
            queueB[i] = queue2[i];
        }
        
        long sum1 = 0;
        long sum2 = 0;
        
        for (int n : queue1) {
            sum1 += n;
        }
        
        for (int n : queue2) {
            sum2 += n;
        }
        
        long half = (sum1 + sum2) / 2;
        
        int idxMin1 = 0;
        int idxMax1 = queue1.length - 1;
        int idxMin2 = 0;
        int idxMax2 = queue2.length - 1;
        
        
        int count = 0;
        
        while (true) {
        
            
            if (sum1 > half) {
                sum1 -= queueA[idxMin1];
                sum2 += queueA[idxMin1];
                idxMax2++;
                queueB[idxMax2] = queueA[idxMin1];
                idxMin1++;
                count++;
                
            } else if (sum2 > half) {
                sum2 -= queueB[idxMin2];
                sum1 += queueB[idxMin2];
                idxMax1++;
                queueA[idxMax1] = queueB[idxMin2];
                idxMin2++;
                count++;
            } else {
                break;
            }
            
            
            if (count > queue1.length * 3) return -1;
        }
        
        
        return count;
        
    }
}




/**
3 + 2 + 7 + 2 = 14
4 + 6 + 5 + 1 = 16

3 + 2 + 7 + 2 + 4 = 18
6 + 5 + 1 = 12

2 + 7 + 2 + 4 = 15
6 + 5 + 1 + 3 = 15


1. half 보다 큰 큐는 pop 한다.
2. 작은 큐에 insert를 한다.






**/