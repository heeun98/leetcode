import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        int size = genres.length;
        
        Map<String, List<Music>> map = new HashMap<>();
        Map<String, Integer> playCount = new HashMap<>();
        
        // 많이 재생된 장르를 뽑아야한다.
        
        for (int i = 0; i < size; i++) {
            playCount.put(genres[i], playCount.getOrDefault(genres[i], 0) +  plays[i]);
        }
        
        List<String> bestGenres = playCount.keySet().stream()
            .sorted((o1, o2) -> playCount.get(o2) - playCount.get(o1))
            .toList();
        
        
        for (int i = 0; i < genres.length; i++) {
            
            if (!map.containsKey(genres[i])) { // 장르가 처음 나온 경우
                map.put(genres[i], new ArrayList<>());
            }
            Music music = new Music(i, plays[i]);
            map.get(genres[i]).add(music);
        }
        
        for (String genre : map.keySet()) {
            List<Music> musics = map.get(genre);
            
            Collections.sort(musics, (o1, o2) -> {
                if (o1.count != o2.count) {
                    return o2.count - o1.count;
                }
                return o1.num - o2.num;
            });
        }
        
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        
        for (String genre : bestGenres) {
            List<Music> list = map.get(genre);
            for (int i = 0; i < 2; i++) {
                
                if (list.size() - 1 < i) break;
                int num = list.get(i).num;
                result.add(num);
            }
        }
        
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    
    static class Music {
        
        int num;
        int count;
        
        public Music(int num , int count) {
            this.num = num;
            this.count = count;
        }
        
    }
}