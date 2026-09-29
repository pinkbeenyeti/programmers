import java.util.*;
import java.io.*;

public class Main {

    private static class Info implements Comparable<Info> {
        int index, time, value;

        public Info(int i, int t, int v) {
            index = i;
            time = t;
            value = v;
        }

        @Override
        public int compareTo(Info other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answers = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Info> infos = new PriorityQueue<>();
        PriorityQueue<Integer> seats = new PriorityQueue<>();

        int[] answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            infos.offer(new Info(i, s, 1));
            infos.offer(new Info(i, e, -1));

            seats.offer(i);
        }

        while (!infos.isEmpty()) {
            Info info = infos.poll();

            if (info.value == 1)
                answer[info.index] = seats.poll();
            else
                seats.offer(answer[info.index]);
        }

        for (int i = 1; i <= N; i++) {
            answers.append(answer[i]).append(" ");
        }

        System.out.print(answers);
    }
}