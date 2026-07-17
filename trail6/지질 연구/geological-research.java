import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        List<Integer>[] lines = new List[N + 1];
        for (int i = 1; i <= N; i++) lines[i] = new ArrayList<>();

        Queue<Integer> qu = new LinkedList<>();

        int[] degrees = new int[N + 1];
        int[] press = new int[N + 1];

        int[] maxIncomingPress = new int[N + 1];
        int[] maxIncomingCount = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            lines[from].add(to);
            degrees[to]++;
        }

        for (int i = 1; i <= N; i++) {
            if (degrees[i] == 0) {
                press[i] = 1;
                qu.offer(i);
            }
        }

        while (!qu.isEmpty()) {
            int node = qu.poll();

            for (int next : lines[node]) {
                if (press[node] > maxIncomingPress[next]) {
                    maxIncomingPress[next] = press[node];
                    maxIncomingCount[next] = 1;
                }
                else if (press[node] == maxIncomingPress[next]) {
                    maxIncomingCount[next]++;
                }

                degrees[next]--;

                if (degrees[next] == 0) {
                    if (maxIncomingCount[next] >= 2) press[next] = maxIncomingPress[next] + 1;
                    else press[next] = maxIncomingPress[next];
                    qu.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, press[i]);
        }

        System.out.print(answer);
    }
}