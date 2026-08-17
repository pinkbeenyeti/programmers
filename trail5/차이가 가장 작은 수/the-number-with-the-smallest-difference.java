import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        for (int num : set) {
            Integer x = set.ceiling(num + M);
            
            if (x != null) {
                answer = Math.min(answer, x - num);
            }
        }

        if (answer != Integer.MAX_VALUE)
            System.out.print(answer);
        else
            System.out.print(-1);
    }
}