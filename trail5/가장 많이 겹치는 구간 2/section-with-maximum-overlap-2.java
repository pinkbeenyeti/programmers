import java.io.*;
import java.util.*;

public class Main {

    private static class Point {
        int point, value;

        public Point(int point, int value) {
            this.point = point;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            points.add(new Point(a, 1));
            points.add(new Point(b, -1));
        }

        Collections.sort(points, (a, b) -> {
            return Integer.compare(a.point, b.point);
        });

        int overlay = 0;
        int answer = 0;

        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);

            overlay += point.value;
            answer = Math.max(answer, overlay);
        }

        System.out.print(answer);
    }
}