class Solution {
    String[] scales = new String[]{"C#", "D#", "F#", "G#", "A#", "B#"};
    String[] trans = new String[]{"c", "d", "f", "g", "a", "b"};
    
    private int transformTime(String[] time) {
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
    private boolean isContainedMelody(String melody, String m, int playedTime) {
        String playedMelody;
        
        if (playedTime < melody.length()) playedMelody = melody.substring(0, playedTime);
        else {
            StringBuilder melodyBuilder = new StringBuilder();
            
            while (melodyBuilder.length() < playedTime) {
                melodyBuilder.append(melody);
            }
            
            playedMelody = melodyBuilder.substring(0, playedTime);
        }
        
        if (playedMelody.length() < m.length()) return false;
        else {
            if (playedMelody.contains(m)) return true;
            else return false;
        }
    }
    
    private String replaceSharps(String melody) {
        for (int i = 0; i < scales.length; i++) {
            melody = melody.replace(scales[i], trans[i]);
        }
        
        return melody;
    }
    
    public String solution(String m, String[] musicinfos) {
        m = replaceSharps(m);
        
        String answer = "(None)";
        int answerPlayedTime = 0;
        
        for (String musicinfo : musicinfos) {
            String[] splited = musicinfo.split(",");
            String[] start = splited[0].split(":"), end = splited[1].split(":");
            int sTime = transformTime(start), eTime = transformTime(end);
            int playedTime = eTime - sTime;
            
            if (isContainedMelody(replaceSharps(splited[3]), m, playedTime)) {
                if (playedTime > answerPlayedTime) {
                    answer = splited[2];
                    answerPlayedTime = playedTime;
                }
            }
        }
        
        return answer;
    }
}