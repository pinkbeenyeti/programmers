import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.PriorityQueue;

class Solution {
    private class File implements Comparable<File> {
        int index;
        String HEAD, NUMBER, TAIL, compareHEAD, compareTAIL;
        
        public File(int index, String HEAD, String NUMBER, String TAIL) {
            this.index = index;
            
            this.HEAD = HEAD;
            this.NUMBER = NUMBER;
            this.TAIL = TAIL;
            
            this.compareHEAD = HEAD.toLowerCase();
            this.compareTAIL = TAIL.toLowerCase();
        }
        
        @Override
        public int compareTo(File other) {
            if (!this.compareHEAD.equals(other.compareHEAD)) return this.compareHEAD.compareTo(other.compareHEAD);
            if (Integer.parseInt(this.NUMBER) != Integer.parseInt(other.NUMBER)) return Integer.parseInt(this.NUMBER) - Integer.parseInt(other.NUMBER);
            
            return this.index - other.index;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        int index = 0;
        
        PriorityQueue<File> pq = new PriorityQueue<>();
        Pattern pattern = Pattern.compile("([^0-9]+)([0-9]+)(.*)");
        
        for (int i=0; i<files.length; i++) {
            Matcher matcher = pattern.matcher(files[i]);
            
            if (matcher.find()) {
                String HEAD = matcher.group(1);
                String NUMBER = matcher.group(2);
                String TAIL = matcher.group(3);
                
                pq.offer(new File(i, HEAD, NUMBER, TAIL));
            }
        }
        
        while (!pq.isEmpty()) {
            File file = pq.poll();
            
            answer[index] = file.HEAD + file.NUMBER + file.TAIL;
            index++;
        }
        
        return answer;
    }
}