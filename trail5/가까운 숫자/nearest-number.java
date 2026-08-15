import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int diff = Integer.MAX_VALUE;

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int target = Integer.parseInt(st.nextToken());

            Integer low = set.lower(target);
            Integer high = set.higher(target);

            if (low != null) diff = Math.min(diff, target - low);
            if (high != null) diff = Math.min(diff, high - target);

            answer.append(diff + "\n");
            set.add(target);
        }

        System.out.print(answer);
    }
}