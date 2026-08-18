import java.util.*;
import java.io.*;

public class Main {

    private static class Info implements Comparable<Info> {
        int value, abs;

        public Info(int value) {
            this.value = value;
            this.abs = Math.abs(value);
        }

        @Override
        public int compareTo(Info other) {
            if (this.abs != other.abs) 
                return Integer.compare(this.abs, other.abs);
            else
                return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Info> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int command = Integer.parseInt(br.readLine());

            if (command != 0) pq.offer(new Info(command));
            else {
                if (pq.isEmpty()) answer.append(0);
                else answer.append(pq.poll().value);
                answer.append("\n");
            }
        }

        System.out.print(answer);
    }
}