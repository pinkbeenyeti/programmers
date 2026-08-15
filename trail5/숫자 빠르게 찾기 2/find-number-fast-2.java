import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) set.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < M; i++) {
            Integer target = set.ceiling(Integer.parseInt(br.readLine()));
            answer.append(target == null ? -1 : target).append("\n");
        }

        System.out.print(answer);
    }
}