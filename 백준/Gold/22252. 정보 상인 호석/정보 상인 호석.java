import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int Q;
    private static long answer = 0;

    private static List<String> queries;
    private static Map<String, PriorityQueue<Integer>> gorillas;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Q = Integer.parseInt(st.nextToken());
        queries = new ArrayList<>();
        gorillas = new HashMap<>();

        for (int i = 1; i <= Q; i++) {
            queries.add(br.readLine());
        }
    }

    private static void insertNewInfo(String[] info) {
        int count = Integer.parseInt(info[2]);
        PriorityQueue<Integer> infos;

        if (gorillas.containsKey(info[1])) {
            infos = gorillas.get(info[1]);
        } else {
            infos = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i=0; i<count; i++) {
            infos.offer(Integer.parseInt(info[3 + i]));
        }

        gorillas.put(info[1], infos);
    }

    private static void getInfo(String[] info) {
        if (gorillas.containsKey(info[1])) {
            int count = 0, limit = Integer.parseInt(info[2]);
            PriorityQueue<Integer> infos = gorillas.get(info[1]);

            while (!infos.isEmpty() && count < limit) {
                answer += infos.poll();
                count++;
            }
        }
    }

    private static void process() {
        for (String query : queries) {
            String[] info = query.split(" ");

            if (info[0].equals("1")) insertNewInfo(info);
            else if (info[0].equals("2")) getInfo(info);
        }

        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
