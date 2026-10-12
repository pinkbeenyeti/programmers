import java.io.*;
import java.util.*;

public class Main {

    private static class Segment implements Comparable<Segment> {
        int id, y;

        public Segment(int id, int y) {
            this.id = id;
            this.y = y;
        }

        @Override
        public int compareTo(Segment o) {
            if (this.y != o.y) return Integer.compare(this.y, o.y);
            return Integer.compare(this.id, o.id);
        }
    }

    private static class Info implements Comparable<Info> {
        int id, x, y, v;

        public Info(int id, int x, int y, int v) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.v = v;
        }

        @Override
        public int compareTo(Info other) {
            return Integer.compare(this.x, other.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Info> pq = new PriorityQueue<>();
        Segment[] segments = new Segment[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            segments[i] = new Segment(i, y);
            pq.offer(new Info(i, x1, y, 1));
            pq.offer(new Info(i, x2, y, -1));
        }

        TreeSet<Segment> active = new TreeSet<>();
        Set<Integer> visibleColors = new HashSet<>();

        int prevX = -1;

        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            if (prevX != -1 && cur.x > prevX && !active.isEmpty()) {
                visibleColors.add(active.first().id);
            }

            if (cur.v == 1) {
                active.add(segments[cur.id]);
            }         
            else {
                active.remove(segments[cur.id]);
            }

            prevX = cur.x;
        }

        System.out.print(visibleColors.size());
    }
}