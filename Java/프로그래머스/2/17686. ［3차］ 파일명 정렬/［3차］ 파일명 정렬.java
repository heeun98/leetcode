import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        File[] fileResult = new File[files.length];
        int idx = 0;
        
        
        for (String tmp : files) {
            File file = new File(tmp);
            fileResult[idx] = file;
            idx++;
        }
        
        // 문자열 비교와, 정수 비교 문법 숙지.
        // 안정 정렬 숙지. 자바는 언제 안정 정렬을 제공하는지 숙지.
        Arrays.sort(fileResult, (o1, o2) -> {
            if (!o1.head.equals(o2.head)) {
                return o1.head.compareTo(o2.head);
            }
            return Integer.compare(o1.number, o2.number);
        });
        
        
        // 객체 배열을 문자열 배여롤 바꾸는 Stream 숙지
        return Arrays.stream(fileResult)
            .map(o -> o.s)
            .toArray(size -> new String[size]);
    }
    
    
    static class File {
        
        String s;
        String head;
        int number;
        
        
        public File(String s) {
            this.s = s;
            
            int i = 0;
            
            while (i < s.length() && !Character.isDigit(s.charAt(i))) i++;
            
            int j = i;
            this.head = s.substring(0, i).toLowerCase(); // 문법 숙지.
            
            // i - j < 5 숙지
            while (i < s.length() && Character.isDigit(s.charAt(i)) && i - j < 5) i++;
            
            this.number = Integer.parseInt(s.substring(j, i));
        }
        
        
    }
}