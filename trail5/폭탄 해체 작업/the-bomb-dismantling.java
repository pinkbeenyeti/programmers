import java.io.*;
import java.util.*;

public class Main {

    private static class Bomb {
        int score, end;

        public Bomb(int s, int e) {
            this.score = s;
            this.end = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Bomb[] bombs = new Bomb[N];
        int maxTime = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            bombs[i] = new Bomb(s, e);
            maxTime = Math.max(maxTime, e);
        }

        Arrays.sort(bombs, (a, b) -> Integer.compare(b.end, a.end));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int answer = 0;
        int bombIdx = 0;

        for (int t = maxTime - 1; t >= 0; t--) {
            while (bombIdx < N && bombs[bombIdx].end > t) {
                pq.offer(bombs[bombIdx].score);
                bombIdx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}