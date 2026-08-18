import java.io.*;
import java.util.*;

public class Main {

    private static class Spot implements Comparable<Spot> {
        int x, y, d;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
            this.d = x + y;
        }

        @Override
        public int compareTo(Spot other) {
            if (this.d != other.d)
                return Integer.compare(this.d, other.d);
            else if (this.x != other.x)
                return Integer.compare(this.x, other.x);
            else
                return Integer.compare(this.y, other.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Spot> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.offer(new Spot(x, y));
        }

        for (int i = 0; i < M; i++) {
            Spot spot = pq.poll();
            pq.offer(new Spot(spot.x + 2, spot.y + 2));
        }

        Spot spot = pq.poll();
        System.out.print(spot.x + " " + spot.y);
    }
}