import java.util.*;
import java.io.*;

public class Main {

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.add(new Point(x, y));
        }
        Collections.sort(points, (a, b) -> {
            return Integer.compare(a.x, b.x);
        });

        int l = 0, r = 0;
        int answer = 2_000_000;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(points.get(0).y, 1);

        while (r < N) {
            if (map.lastKey() - map.firstKey() < M) {
                if (r < (N - 1)) {
                    map.put(points.get(r + 1).y, map.getOrDefault(points.get(r + 1).y, 0) + 1);
                }
                r++;
            }
            else {
                answer = Math.min(answer, points.get(r).x - points.get(l).x);
                if (map.get(points.get(l).y) == 1) map.remove(points.get(l).y);
                else map.put(points.get(l).y, map.get(points.get(l).y) - 1);
                l++;
            }
        }

        if (answer == 2_000_000) System.out.print(-1);
        else System.out.print(answer);
    }
}