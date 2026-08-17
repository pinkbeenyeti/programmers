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

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            Integer num = set.floor(Integer.parseInt(st.nextToken()));

            if (num == null) 
                answer.append(-1);
            else {
                answer.append(num);
                set.remove(num);
            }

            answer.append("\n");
        }

        System.out.print(answer);
    }
}