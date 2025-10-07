class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] video_len_splited = video_len.split(":");
        String[] pos_splited = pos.split(":");
        String[] op_start_splited = op_start.split(":");
        String[] op_end_splited = op_end.split(":");
        
        int video_len_trans = Integer.parseInt(video_len_splited[0]) * 60 + Integer.parseInt(video_len_splited[1]);
        int pos_trans = Integer.parseInt(pos_splited[0]) * 60 + Integer.parseInt(pos_splited[1]);
        int op_start_trans = Integer.parseInt(op_start_splited[0]) * 60 + Integer.parseInt(op_start_splited[1]);
        int op_end_trans = Integer.parseInt(op_end_splited[0]) * 60 + Integer.parseInt(op_end_splited[1]);
        
        if (pos_trans >= op_start_trans && pos_trans <= op_end_trans) {
            pos_trans = op_end_trans;
        }
        
        for (String command : commands) {
            if (command.equals("next")) {
                if (pos_trans > video_len_trans - 10) pos_trans = video_len_trans;
                else pos_trans += 10;
            }
            
            if (command.equals("prev")) {
                if (pos_trans < 10) pos_trans = 0;
                else pos_trans -= 10;
            }
            
            if (pos_trans >= op_start_trans && pos_trans <= op_end_trans) {
                pos_trans = op_end_trans;
            }
        }
        
        String minute = ((pos_trans / 60) < 10) ? ("0" + (pos_trans / 60) + ":") : ((pos_trans / 60) + ":");
        String second = ((pos_trans % 60) < 10) ? ("0" + (pos_trans % 60)) : ((pos_trans % 60) + "");
        
        return minute + second;
    }
}