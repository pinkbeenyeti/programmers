import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, X;
    private static int[] presents;

    private static class Plant implements Comparable<Plant>{
        int index;
        long time;

        public Plant(int index, long time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Plant other) {
            return Long.compare(this.time, other.time);
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        presents = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            presents[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static long getTime(int plantCount) {
        if (plantCount >= N) {
            List<Plant> list = new ArrayList<>();

            for (int i=1; i<=N; i++) {
                list.add(new Plant(i, presents[i]));
            }

            Collections.sort(list);
            return list.get(N - 1).time;
        } else {
            PriorityQueue<Plant> pq = new PriorityQueue<>();
            int index = plantCount + 1;

            for (int i=1; i<=plantCount; i++) {
                pq.offer(new Plant(i, presents[i]));
            }

            while (index <= N) {
                Plant plant = pq.poll();
                plant.time += presents[index];

                pq.offer(plant);
                index++;
            }

            while (pq.size() > 1) {
                pq.poll();
            }

            return pq.poll().time;
        }
    }

    private static void process() {
        int L = 1, R = N, answer = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            long time = getTime(mid);

            if (time <= X) {
                answer = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
