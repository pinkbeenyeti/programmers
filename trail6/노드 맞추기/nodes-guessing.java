import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        String[] nodes = br.readLine().split(" ");
        Arrays.sort(nodes);

        Map<String, Integer> numMap = new HashMap<>();
        Map<Integer, String> mapNum = new HashMap<>();

        for (int i = 0; i < N; i++) {
            numMap.put(nodes[i], i + 1);
            mapNum.put(i + 1, nodes[i]);
        }

        List<Integer>[] lines = new List[N + 1];
        List<String>[] childs = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            lines[i] = new ArrayList<>();
            childs[i] = new ArrayList<>();
        }
        
        int M = Integer.parseInt(br.readLine());
        int[] degrees = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int child = numMap.get(st.nextToken());
            int ances = numMap.get(st.nextToken());

            lines[ances].add(child);
            degrees[child]++;
        }

        Queue<Integer> qu = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (degrees[i] == 0) {
                answer.append(mapNum.get(i)).append(" ");
                visited[i] = true;
                qu.offer(i);
            }
        }

        answer.insert(0, qu.size() + "\n");
        answer.append("\n");

        while (!qu.isEmpty()) {
            int current = qu.poll();

            for (int child : lines[current]) {
                if (degrees[child] == 1 && !visited[child]) {
                    childs[current].add(mapNum.get(child));
                    visited[child] = true;
                    qu.offer(child);
                }
                degrees[child]--;
            }
        }

        for (int i = 1; i <= N; i++) {
            answer.append(mapNum.get(i)).append(" ");

            Collections.sort(childs[i]);
            answer.append(childs[i].size()).append(" ");

            for (int j = 0; j < childs[i].size(); j++) {
                answer.append(childs[i].get(j)).append(" ");
            }

            answer.append("\n");
        }

        System.out.print(answer);
    }
}