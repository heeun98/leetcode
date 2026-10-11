class Solution {
    public int thirdMax(int[] nums) {
        

        TreeSet<Integer> ts = new TreeSet<>((a, b) -> Integer.compare(b, a));
        for (int n : nums) {
            ts.add(n);
        }
        int max = ts.first();

        for (int i = 0; i < 2; i++) {
            ts.pollFirst();
        }
        Integer result = ts.pollFirst();
        if (result == null) {
            return max;
        } else {
            return result;
        }
    }
}