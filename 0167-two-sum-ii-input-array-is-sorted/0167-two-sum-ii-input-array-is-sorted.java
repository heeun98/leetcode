class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        
        while (true) {

            sum = numbers[left] + numbers[right];

            if (sum == target) return new int[]{left + 1, right + 1};
            
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }

            if (left >= right) break;

            
        }

        return new int[]{left, right};

    }
}