import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int index = 0;

        for (int num : set) {
            if (index == K) break;
            else {
                answer.append(num + " ");
                index++;
            }
        }

        System.out.print(answer);
    }
}