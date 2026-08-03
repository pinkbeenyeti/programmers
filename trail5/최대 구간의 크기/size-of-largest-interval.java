import java.io.*;
import java.util.*;

public class Main {

    private static class Point {
        int pos, value;

        public Point(int pos, int value) {
            this.pos = pos;
            this.value = value;
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
            points.add(new Point(b, - 1));
        }

        Collections.sort(points, (a, b) -> {
            return Integer.compare(a.pos, b.pos);
        });

        int start = 0;
        int overlay = 0;

        for (Point point : points) {
            if (point.value == 1) {
                start = start == 0 ? point.pos : start;
                overlay++;
            }

            if (point.value == -1) {
                overlay--;
            }

            if (overlay == 0) {
                answer = Math.max(answer, point.pos - start);
                start = 0;
            }
        }

        System.out.print(answer);
    }
}