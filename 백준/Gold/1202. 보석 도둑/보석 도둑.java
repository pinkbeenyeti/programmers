import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> gems = new ArrayList<>();
        List<Integer> bags = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            gems.add(new int[]{M, V});
        }

        for (int i=0; i<K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        gems.sort((a, b) -> (a[0] - b[0]));
        Collections.sort(bags);

        PriorityQueue<Integer> gemValues = new PriorityQueue<>(Collections.reverseOrder());
        int gemIndex = 0;

        for (int bag : bags) {

            for (int i=gemIndex; i<gems.size(); i++) {
                int[] gem = gems.get(i);

                if (gem[0] > bag) break;
                else {
                    gemValues.offer(gem[1]);
                    gemIndex++;
                }
            }

            if (!gemValues.isEmpty()) {
                answer += gemValues.poll();
            }
        }

        System.out.print(answer);
    }
}
