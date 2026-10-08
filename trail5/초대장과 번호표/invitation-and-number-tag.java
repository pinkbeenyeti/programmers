import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        Set<Integer>[] groupNums = new Set[G + 1];
        Map<Integer, Set<Integer>> numGroups = new HashMap<>();

        for (int i = 1; i <= G; i++) {
            groupNums[i] = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= count; j++) {
                int number = Integer.parseInt(st.nextToken());

                groupNums[i].add(number);

                Set<Integer> temp = numGroups.getOrDefault(number, new HashSet<>());
                temp.add(i);
                numGroups.put(number, temp);
            }
        }

        int answer = 0;

        Set<Integer> invited = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        invited.add(1);
        pq.offer(1);

        while (!pq.isEmpty()) {
            answer++;
            int number = pq.poll();

            Set<Integer> groups = numGroups.get(number);
            if (groups == null) continue;

            for (int group : groups) {
                groupNums[group].remove(number);
                if (groupNums[group].size() == 1) {
                    for (int num : groupNums[group]) {
                        if (!invited.contains(num)) {
                            invited.add(num);
                            pq.offer(num);
                        }
                    }
                }
            }
        }

        System.out.print(answer);
    }
}