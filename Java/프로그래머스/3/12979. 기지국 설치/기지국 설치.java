class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1;// 기지국 하나가 커버하는 폭
        int lastCovered = 0;// 지금까지 커버된 마지막 아파트 위치

        for (int station : stations) {
            int coverStart = station - w;
            int coverEnd = station + w;

            int gap = coverStart - lastCovered - 1;
            if (gap > 0) {
                answer += (gap + range - 1) / range; 
            }

            lastCovered = Math.max(lastCovered, coverEnd);
        }


        int gap = n - lastCovered;
        if (gap > 0) {
            answer += (gap + range - 1) / range;
        }

        return answer;
    }
}