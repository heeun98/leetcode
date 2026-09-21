import java.util.*;


class Solution {
    public String[] solution(String[] files) {
        
        
        File[] result = new File[files.length];
        int idx = 0;
        
        for (String name : files) {
            
            int numIdx = findIndexFirstNumber(name);
            // 3
            
            String head = name.substring(0, numIdx).toLowerCase();
                        
            int lastNumIdx = findIndexEndOfDigit(name.substring(numIdx));
            // 1
            String number = name.substring(numIdx, numIdx + lastNumIdx);
            // 3, 3 + 1
            String tail = name.substring(numIdx + lastNumIdx);
            result[idx] = new File(name, head, Integer.parseInt(number), tail);
            idx++;
        }
        
        
        Arrays.sort(result, (o1, o2) -> {
            if (!o1.head.equals(o2.head)) {
                return o1.head.compareTo(o2.head);
            }
        
            return Integer.compare(o1.number, o2.number);
            
            
        });
        
        
        return Arrays.stream(result)
            .map(o -> o.origin)
            .toArray(size -> new String[size]);
    }
    
    
    public class File {
        
        String origin;
        String head;
        int number;
        String tail;
        
        public File (String origin, String head, int number, String tail) {
            this.origin = origin;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
    
    
    public int findIndexFirstNumber(String fileName) {
        
        char[] sequence = fileName.toCharArray();
        
        for (int i = 0; i < sequence.length; i++) {
            if (!Character.isDigit(sequence[i])) continue;
            return i;
        }
        
        return fileName.length();
    }
    
    
    public int findIndexEndOfDigit(String fileName) {
        
        
        char[] sequence = fileName.toCharArray();
        
        for (int i = 0; i < sequence.length; i++) {
            if (Character.isDigit(sequence[i])) continue;
            return i;
        }
        
        return fileName.length();
        
        
        
        
    }
}