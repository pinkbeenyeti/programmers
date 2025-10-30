class Solution {
    private class Log {
        long start, end;
        
        public Log(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
    
    private long timeToMs(String time) {
        String[] timeSplited = time.split(":");
        
        long hour = Long.parseLong(timeSplited[0]) * 3600000, minute = Long.parseLong(timeSplited[1]) * 60000;
        double second =  Double.parseDouble(timeSplited[2]) * 1000;
        
        return hour + minute + (long) second;
    }
    
    public int solution(String[] lines) {
        Log[] logs = new Log[lines.length];
        int answer = 1;
        
        for (int i=0; i<lines.length; i++) {
            String[] splited = lines[i].split(" ");
            
            long end = timeToMs(splited[1]);
            long processed = (long) (Double.parseDouble(splited[2].substring(0, splited[2].length() - 1)) * 1000);
            
            logs[i] = new Log(end - processed + 1, end);
        }
        
        for (int i=0; i<(logs.length - 1); i++) {
            long start1 = logs[i].start, start2 = logs[i].end;
            long end1 = start1 + 999, end2 = start2 + 999;
            int currentProcess1 = 1, currentProcess2 = 1;
            
            for (int j=(i + 1); j<logs.length; j++) {
                long nowStart = logs[j].start, nowEnd = logs[j].end;
                
                if (nowStart <= end1 && nowEnd >= start1) {
                    currentProcess1++;
                }
                
                if (nowStart <= end2 && nowEnd >= start2) {
                    currentProcess2++;
                }
            }
            
            answer = Math.max(Math.max(answer, currentProcess1), currentProcess2);
        }
        
        return answer;
    }
}