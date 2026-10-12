import java.io.*;
import java.util.*;

public class Main {

    private static class Info implements Comparable<Info> {
        int id, x, v;

        public Info(int id, int x, int v) {
            this.id = id;
            this.x = x;
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
        Set<Integer> ids = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.offer(new Info(i, a, 1));
            pq.offer(new Info(i, b, -1));
        }

        int count = 0, prevX = 0, totalLength = 0;
        int[] ranges = new int[N];

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (info.x > prevX) {
                int len = info.x - prevX;

                if (count >= 1) {
                    totalLength += len;
                }

                if (count == 1) {
                    int onlyId = ids.iterator().next();
                    ranges[onlyId] += len;
                }
            }


            if (info.v == 1) 
                ids.add(info.id);
            else 
                ids.remove(info.id);

            count += info.v;
            prevX = info.x;
        }

        int minUnique = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            minUnique = Math.min(minUnique, ranges[i]);
        }
        System.out.print(totalLength - minUnique);
    }
}