import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {

    private static int n, m, k;

    private static List<Integer>[] e;
    private static int[] reachCount;
    private static int[] maxTime;

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        reachCount = new int[n + 1];
        maxTime = new int[n + 1];

        e = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) e[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            e[a].add(b);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            int start = Integer.parseInt(st.nextToken());
            findConnections(start);
        }

        int answer = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 1; i <= n; i++) {
            if (reachCount[i] == k) {
                answer = Math.min(answer, maxTime[i]);
                found = true;
            }
        }

        System.out.print(found ? answer : -1);
    }

    private static void findConnections(int start) {
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{start, 0});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        while (!qu.isEmpty()) {
            int[] curr = qu.poll();

            int currNode = curr[0];
            int currDist = curr[1];

            reachCount[currNode]++;
            maxTime[currNode] = Math.max(maxTime[currNode], currDist);

            for (int next : e[currNode]) {
                if (dist[next] == -1) {
                    dist[next] = currDist + 1;
                    qu.offer(new int[]{next, currDist + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}