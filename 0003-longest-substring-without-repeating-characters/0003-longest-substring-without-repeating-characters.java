class Solution {
    public int lengthOfLongestSubstring(String s) {
        

        int left = 0;
        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        int result = 0;

        for (int right = 0; right < arr.length; right++) {

            int index = sb.toString().indexOf(s.charAt(right));

            if (index != -1) { // 존재
                String tmp = sb.substring(index + 1);
                sb.setLength(0);
                sb.append(tmp);
                sb.append(s.charAt(right));
            } else {
                sb.append(s.charAt(right));
                result = Math.max(result, sb.toString().length());
                System.out.println(sb.toString());
            }
        }


        return result;
    }
}