import java.io.*;
import java.util.*;

public class Main {

    private static List<Point> points = new ArrayList<>();
    private static int current = 0;

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
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int len = Integer.parseInt(st.nextToken());
            int dir = st.nextToken().equals("R") ? 1 : -1;

            addPoint(len, dir);
        }

        Collections.sort(points, (a, b) -> {
            if (a.pos == b.pos) return Integer.compare(b.value, a.value);
            return Integer.compare(a.pos, b.pos);
        });

        int lines = 0;
        int start = 0;

        for (Point point : points) {
            if (lines >= K) answer += point.pos - start;
            lines += point.value;
            start = point.pos;
        }

        System.out.print(answer);
    }

    private static void addPoint(int len, int dir) {
        int a = Math.min(current, current + (len * dir));
        int b = Math.max(current, current + (len * dir));

        points.add(new Point(a, 1));
        points.add(new Point(b, -1));
        
        if (dir == 1) current = b;
        else current = a;
    }
}