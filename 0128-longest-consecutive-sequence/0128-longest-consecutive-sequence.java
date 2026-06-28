class Solution {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int result = 1;

        Set<Integer> set = new HashSet<>();


        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int count = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1) + 1) {
                count++;
                result = Math.max(result, count);
            } else {
                count = 1;
            }

        }
     
        return result;

    }
}