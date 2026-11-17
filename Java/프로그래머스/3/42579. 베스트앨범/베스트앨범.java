import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        
        Map<String, Integer> genrePlay = new HashMap<>();
        List<Song> songs = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            genrePlay.put(genres[i], 
                          genrePlay.getOrDefault(genres[i], 0) + plays[i]);
            songs.add(new Song(i, genres[i], plays[i]));
        }
        
        
        songs.sort(
            (a, b) -> {
                if (genrePlay.get(b.genres) != genrePlay.get(a.genres)) {
                return genrePlay.get(b.genres) - genrePlay.get(a.genres);
                }
                
                return b.plays - a.plays;
            }
        );
        
        
        List<Integer> result = new ArrayList<>();
        int count = 0;
        String prev = "";
        for (Song s : songs) {
            
            if (!prev.equals(s.genres)) {
                count = 0;
                result.add(s.idx);
                prev = s.genres;
                count++;
            } else if (count < 2) {
                result.add(s.idx);
                prev = s.genres;
                count++;
            }
            
            
        }
        
        System.out.println(result);
        
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
    
    
    private static class Song {
        
        int idx;
        String genres;
        int plays;
        
        
        public Song(int idx, String genres, int plays) {
            this.idx = idx;
            this.genres = genres;
            this.plays = plays;
        }
        
    }
}


 // - 가장 많이 재생된 노래 "두 개씩"
// 재생된 횟수가 많은 장르부터
// 장르 내에서는 많이 재생된 노래 먼저
// 재생 횟수가 같은 경우는 고유 번호가 낮은 노래를 먼저 수록.