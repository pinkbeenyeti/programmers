class Solution {
    private int playTime, advTime, answer = 0;
    private long[] watched;
    
    private int transTime(String[] time) {
        return Integer.parseInt(time[0]) * 3600 + Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
    }
    
    private String toTime(long time) {
        long hour = time / 3600;
        time %= 3600;
        
        long minute = time / 60;
        long second = time % 60;
        
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    
    private void preProcess(String[] play_time, String[] adv_time, String[] logs) {
        playTime = transTime(play_time);
        advTime = transTime(adv_time);
        watched = new long[playTime + 1];
        
        for (String log : logs) {
            String[] start = log.substring(0, 8).split(":"), end = log.substring(9, 17).split(":");
            int start_time = transTime(start), end_time = transTime(end);
            
            watched[start_time] += 1;
            watched[end_time] += -1;
        }
    }
    
    private void process() {
        long maxWatched = 0, currentWatched = 0;
        
        for (int i=1; i<=playTime; i++) {
            watched[i] += watched[i - 1];
        }
        
        for (int i=1; i<advTime; i++) {
            maxWatched += watched[i];
            currentWatched += watched[i];
        }
        
        for (int i=advTime; i<=playTime; i++) {
            currentWatched = currentWatched + watched[i] - watched[i - advTime];
            
            if (currentWatched > maxWatched) {
                maxWatched = currentWatched;
                answer = i - advTime + 1;
            }
        }
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        preProcess(play_time.split(":"), adv_time.split(":"), logs);
        process();
        
        return toTime(answer);
    }
}