import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int count = 1;

        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        for (int spot : set) {
            map.put(spot, count);
            count++;
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Integer aOrder = set.lower(a);
            Integer bOrder = set.higher(b);

            int low = aOrder == null ? 0 : map.get(aOrder);
            int high = bOrder == null ? N + 1 : map.get(bOrder);

            answer.append(high - low - 1).append("\n");
        }

        System.out.print(answer);
    }
}