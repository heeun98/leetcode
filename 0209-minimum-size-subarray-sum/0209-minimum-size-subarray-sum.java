class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0;
        int right = 0;
        int sum = nums[0];
        int result = nums.length + 1;
        boolean flag = false;

        if (nums.length == 1) {
            if (nums[0] < target) {
                return 0;
            } else {
                return 1;
            }
        }

        while (true) {

            if (sum < target) {
                right++;
                sum += nums[right];
                System.out.println(right);
            } else {
                result = Math.min(result, right - left);
                sum -= nums[left];
                left++;
                System.out.println("left " + left);
                flag = true;
            }
            if (right == nums.length - 1 && sum < target) break;
           
        }

        if (!flag) return 0;
        return result + 1;
    }
}