class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int result = 0;
        
        for (int employee=0; employee<schedules.length; employee++) {
            int limit = ((schedules[employee] + 10) % 100 >= 60) ? (schedules[employee] + 50) : (schedules[employee] + 10);
            boolean success = true;
            
            for (int time=0; time<timelogs[employee].length; time++) {
                int day = (startday + time > 7) ? (startday + time - 7) : startday + time;
                
                if (day > 5) continue;
                if (timelogs[employee][time] > limit) {
                    success = false;
                    break;
                }
            }
            
            if (success) {
                result++;
            }
        }
        
        return result;
    }
}