class Solution {
    public String reverseWords(String s) {
        
        String str = s.trim();// 앞 뒤 공백 제거

        String nov = "";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (count == 0) { // 처음 공백만 넣어
                    nov += " ";
                }
                count++;
            } else {
                count = 0;
                nov += str.charAt(i);
            }
        }

        String[] words = nov.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.toString().trim();

    }
}