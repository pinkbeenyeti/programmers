import java.util.*;

class Solution {
    private class Server {
        int startTime, serverCount;
        
        public Server(int startTime, int serverCount) {
            this.startTime = startTime;
            this.serverCount = serverCount;
        }
    }
    
    public int solution(int[] players, int m, int k) {
        Queue<Server> qu = new LinkedList<>();
        int serverCount = 0, answer = 0;
        
        for (int i=0; i<players.length; i++) {
            if (!qu.isEmpty() && (i - qu.peek().startTime) == k) {
                serverCount -= qu.poll().serverCount;
            }
            
            if ((serverCount + 1) * m <= players[i]) {
                int count = 0;
                
                while ((serverCount + count + 1) * m <= players[i]) {
                    count++;
                }
                
                qu.offer(new Server(i, count));
                serverCount += count;
                answer += count;
            }
        }
        
        return answer;
    }
}