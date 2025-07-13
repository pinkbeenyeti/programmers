import java.util.*;

class Solution {
    class Truck {
        int entryTime, weight;
        
        public Truck(int time, int weight) {
            this.entryTime = time;
            this.weight = weight;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> qu = new LinkedList<>();
        int time = 1, nowWeight = 0;
        
        for (int i=0; i<truck_weights.length; i++) {
            while (true) {
                if (qu.isEmpty() || (nowWeight + truck_weights[i] <= weight && time - qu.peek().entryTime != bridge_length)) {
                    break;
                }
                
                if (time - qu.peek().entryTime == bridge_length) {
                    System.out.println("트럭진입 " + qu.peek().entryTime + " 빠져나감 " + time + " poll ");
                    nowWeight -= qu.poll().weight;
                } else {
                     time = qu.peek().entryTime + bridge_length;
                }
            }
            
            qu.offer(new Truck(time, truck_weights[i]));
            System.out.println("트럭진입 " + time);
            nowWeight += truck_weights[i];
            time++;
        }
        
        while (!qu.isEmpty()) {
            time = qu.poll().entryTime + bridge_length;
            System.out.println("트럭진입 " + time + " poll");
        }
        
        return time;
    }
}