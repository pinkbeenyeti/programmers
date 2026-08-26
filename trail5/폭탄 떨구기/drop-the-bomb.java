import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        TreeSet<Integer> spots = new TreeSet<>();

        for(int i = 1; i <= N; i++) {
            spots.add(Integer.parseInt(br.readLine()));
        } 

        int l = 1, r = 1_000_000_000;
        int answer = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (find(mid, spots) <= K) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.print(answer);
    }

    private static int find(int distance, TreeSet<Integer> spots) {
        Integer l = spots.first();
        Integer r = spots.higher(l + (distance * 2));

        int count = 1;

        while (r != null) {
            l = r;
            r = spots.higher(l + (distance * 2));
            count++;
        }

        return count;
    }
}