import java.util.*;

class Solution {
    class File implements Comparable<File>{
        String HEAD, NUMBER, TAIL;
        int index;
        
        public File(String HEAD, String NUMBER, String TAIL, int index) {
            this.HEAD = HEAD;
            this.NUMBER = NUMBER;
            this.TAIL = TAIL;
            this.index = index;
        }
        
        @Override
        public int compareTo(File other) {
            if (!this.HEAD.equals(other.HEAD)) return this.HEAD.compareTo(other.HEAD);
            if (!this.NUMBER.equals(other.NUMBER)) return Integer.parseInt(this.NUMBER) - Integer.parseInt(other.NUMBER);
            
            return this.index - other.index;
        }
    }
    
    private File getFile(String file, int idx) {
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder tail = new StringBuilder();
        
        int index = 0;
        for (int i=0; i<file.length(); i++) {
            char ch = file.charAt(i);
            if (ch >= '0' && ch <= '9') break;
            
            head.append(ch);
            index++;
        }
        
        for (int i=index; i<file.length(); i++) {
            char ch = file.charAt(i);
            if (ch < '0' || ch > '9') break;
            
            number.append(ch);
            index++;
        }
        
        if (index == file.length()) return new File(head.toString(), number.toString(), "", idx);
    
        return new File(head.toString(), number.toString(), file.substring(index, file.length()), idx);
    }
    
    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        String[] answer = new String[files.length];
        
        for (int i=0; i<files.length; i++) {
            list.add(getFile(files[i].toLowerCase(), i));
        }
        
        Collections.sort(list);
        
        for (int i=0; i<list.size(); i++) {
            answer[i] = files[list.get(i).index];
        }
        
        return answer;
    }
}