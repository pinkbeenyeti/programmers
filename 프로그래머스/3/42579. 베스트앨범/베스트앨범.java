import java.util.*;

class Solution {
    private List<Integer> answer = new ArrayList<>();
    
    private class Song implements Comparable<Song> {
        int index, played;
        
        public Song(int index, int played) {
            this.index = index;
            this.played = played;
        }
        
        @Override
        public int compareTo(Song other) {
            if (this.played != other.played) return other.played - this.played;
            return this.index - other.index;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> forSort = new HashMap<>(); 
        Map<String, PriorityQueue<Song>> map = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            PriorityQueue<Song> pq = map.getOrDefault(genres[i], new PriorityQueue<>());
            pq.offer(new Song(i, plays[i]));
            
            forSort.put(genres[i], forSort.getOrDefault(genres[i], 0) + plays[i]);
            map.put(genres[i], pq);
        }
        
        List<String> sortedGenres = new ArrayList<>(forSort.keySet());
        sortedGenres.sort((a, b) -> forSort.get(b) - forSort.get(a));
        
        for (String key : sortedGenres) {
            PriorityQueue<Song> pq = map.get(key);
            int count = 0;
            
            while (!pq.isEmpty() && count != 2) {
                answer.add(pq.poll().index);
                count++;
            }
        }
        
        return answer.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}