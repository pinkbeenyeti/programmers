import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        Set<Integer>[] groupNums = new HashSet[G + 1];
        List<Integer>[] numGroups = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            numGroups[i] = new ArrayList<>();
        }

        for (int i = 1; i <= G; i++) {
            groupNums[i] = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                int number = Integer.parseInt(st.nextToken());
                groupNums[i].add(number);
                numGroups[number].add(i);
            }
        }

        boolean[] invited = new boolean[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        invited[1] = true;
        queue.offer(1);

        int answer = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            answer++;

            for (int groupIdx : numGroups[current]) {
                groupNums[groupIdx].remove(current);

                if (groupNums[groupIdx].size() == 1) {
                    int remainingPerson = groupNums[groupIdx].iterator().next();
                    if (!invited[remainingPerson]) {
                        invited[remainingPerson] = true;
                        queue.offer(remainingPerson);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}