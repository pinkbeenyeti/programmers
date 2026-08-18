import java.io.*;
import java.util.*;

public class Main {

    private static class Human {
        int index, arrive, remain;

        public Human(int index, int arrive, int remain) {
            this.index = index;
            this.arrive = arrive;
            this.remain = remain;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int idx = 0, time = 0, wait = 0;

        List<Human> humans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int arr = Integer.parseInt(st.nextToken());
            int rem = Integer.parseInt(st.nextToken());

            humans.add(new Human(i, arr, rem));
        }

        Collections.sort(humans, (a, b) -> {
            if (a.arrive != b.arrive)
                return Integer.compare(a.arrive, b.arrive);
            else
                return Integer.compare(a.index, b.index);
        });

        PriorityQueue<Human> waits = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.index, b.index);
        });

        while (idx < N || !waits.isEmpty()) {
            if (waits.isEmpty() && time < humans.get(idx).arrive) {
                time = humans.get(idx).arrive;
            }

            while (idx < N && humans.get(idx).arrive <= time) {
                waits.offer(humans.get(idx));
                idx++;
            }

            Human curr = waits.poll();
            wait = Math.max(wait, time - curr.arrive);
            time += curr.remain;
        }

        System.out.print(wait);
    }
}