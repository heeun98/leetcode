import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> que = new LinkedList<>();
        boolean[] visit = new boolean[words.length];
        
        for (int i = 0; i < words.length; i++) {
            if (isOneDiff(begin, words[i])) {
                que.add(words[i]);
                visit[i] = true;
            }
        }
        int dis = 1;
        boolean flag = false;
        
        System.out.println("BFS 전 큐의 상태 : " + que);
        
        while (!que.isEmpty()) {
            for (int i = 0; i < que.size(); i++) {
                System.out.println("큐 상태 : " + que);
                String word = que.poll();
                
                
                if (word.equals(target)) {
                    flag = true;
                    System.out.println("dis = " + dis);
                    return dis;
                }
                for (int j = 0; j < words.length; j++) {
                    if (visit[j]) continue; // 이미 방문했으면 최소일수가 없음
                    if(isOneDiff(word, words[j])) {// 단어차이 1인지
                        que.add(words[j]);
                        visit[j] = true;
                    }
                }
            }
            
            System.out.println("거리증가! : " + dis);
            dis++;
            System.out.println("거리증가 완료 : " + dis);
            
        }
        
        return 0;
    }
    
    public boolean isOneDiff(String begin, String compare) {
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != compare.charAt(i)) {
                count++;
            }
        }
        
        if (count == 1) return true;
        
        return false;
        
    }
}