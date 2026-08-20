import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] seats = new int[N + 1];
        Set<Integer>[] counts = new Set[N + 1];
        List<int[]> query = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            seats[i] = i;
            counts[i] = new HashSet<>();
            counts[i].add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            query.add(new int[]{a, b});
        }

        for (int i = 0; i < 3; i++) {
            for (int[] q : query) {
                int seat1 = q[0], seat2 = q[1];
                int man1 = seats[seat1], man2 = seats[seat2];

                counts[man1].add(seat2);
                counts[man2].add(seat1);

                seats[seat1] = man2;
                seats[seat2] = man1;
            }
        }

        for (int i = 1; i <= N; i++) {
            answer.append(counts[i].size()).append("\n");
        }

        System.out.print(answer);
    }
}