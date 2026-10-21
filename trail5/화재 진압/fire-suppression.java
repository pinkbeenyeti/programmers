import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] fires = new int[N];
        TreeSet<Integer> buildings = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fires[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            buildings.add(Integer.parseInt(st.nextToken()));
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            Integer a = buildings.lower(fires[i]);
            Integer b = buildings.higher(fires[i]);

            int aa = (a == null) ? Integer.MAX_VALUE : Math.abs(a - fires[i]);
            int bb = (b == null) ? Integer.MAX_VALUE : Math.abs(b - fires[i]);

            answer = Math.max(answer, Math.min(aa, bb));
        }

        System.out.print(answer);
    }
}