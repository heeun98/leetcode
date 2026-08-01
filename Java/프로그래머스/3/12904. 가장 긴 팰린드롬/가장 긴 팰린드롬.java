class Solution {
    public int solution(String s) {
        int n = s.length();
        int best = 1; 

        for (int center = 0; center < n; center++) {
            best = Math.max(best, expand(s, center, center));     // 홀수 길이
            best = Math.max(best, expand(s, center, center + 1)); // 짝수 길이
        }
        return best;
    }

    private int expand(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}