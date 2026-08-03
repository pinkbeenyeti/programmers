import java.io.*;
import java.util.*;

public class Main {

    private static class Point {
        int pos, value;

        public Point(int p, int v) {
            this.pos = p;
            this.value = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            points.add(new Point(a, 1));
            points.add(new Point(b, -1));
        }

        Collections.sort(points, (a, b) -> {
            if (a.pos == b.pos) return Integer.compare(b.value, a.value);
            return Integer.compare(a.pos, b.pos);
        });
        
        int rooms = 0;

        for (Point point : points) {
            rooms += point.value;
            answer = Math.max(answer, rooms);
        }

        System.out.print(answer);
    }
}