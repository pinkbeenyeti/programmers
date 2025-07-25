import java.util.*;

class Solution {
    class Robot {
        boolean isGoal = false;
        Queue<Integer> goals;
        int r, c;
        
        public Robot(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        public String move(int[][] points) {
            int goalR = points[goals.peek()][0], goalC = points[goals.peek()][1];
            
            if (r != goalR) r = (r < goalR) ? (r + 1) : (r - 1); 
            else if (c != goalC) c = (c < goalC) ? (c + 1) : (c - 1);
                
            if (r == goalR && c == goalC) goals.poll();
            if (goals.size() == 0) isGoal = true;
            
            return r + "," + c; 
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        Queue<Robot> qu = new LinkedList<>();
        int answer = 0;
        
        for (int[] route : routes) {
            Robot robot = new Robot(points[route[0] - 1][0], points[route[0] - 1][1]);
            robot.goals = new LinkedList<>();
            
            for (int i=0; i<route.length; i++) {
                robot.goals.offer(route[i] - 1);
            }
            
            qu.offer(robot);
        }
        
        int time = 0;
        while (!qu.isEmpty()) {
            Map<String, Integer> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            int size = qu.size();
            
            for (int i=0; i<size; i++) {
                Robot robot = qu.poll();
                String pointKey = robot.move(points);
                int count = map.getOrDefault(pointKey, 0) + 1;
                map.put(pointKey, count);
                
                if (!robot.isGoal) qu.offer(robot);
                if (count > 1 && !set.contains(pointKey)) {
                    set.add(pointKey);
                    answer++;
                }
            }
            
            time++;
        }
        
        return answer;
    }
}