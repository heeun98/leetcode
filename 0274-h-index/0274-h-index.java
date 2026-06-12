import java.util.*;
import java.util.stream.*;

class Solution {
    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int min = citations[0];
        int max = citations[citations.length - 1];
        int result = 0;
        int idx = 0;
        for (int i = 0; i <= max; i++) {

            for (int j = 0; j < citations.length; j++) {
                if (i <= citations[j]) {
                    idx = j;
                    break;
                }
            }

            int count = citations.length - idx; // 나보다 큰 숫자의 개수
            if (i <= count) {
                result = i;
            } else {
                break;
            }

        }

        return result;

    }
}


// 5,000,000
