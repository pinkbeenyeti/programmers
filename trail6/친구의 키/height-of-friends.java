import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] lines = new List[N + 1];
        for (int i = 1; i <= N; i++) lines[i] = new ArrayList<>();

        int[] degrees = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines[a].add(b);
            degrees[b]++;
        }

        Queue<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degrees[i] == 0) {
                qu.offer(i);
                visited[i] = true;
            }
        }

        while (!qu.isEmpty()) {
            int current = qu.poll();
            answer.append(current).append(" ");

            for (int small : lines[current]) {
                if (degrees[small] == 1 && !visited[small]) {
                    qu.offer(small);
                    visited[small] = true;
                }
                degrees[small]--;
            }
        }

        System.out.print(answer);
    }
}