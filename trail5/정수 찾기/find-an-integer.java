import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Set<Integer> set =  new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) set.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            if (set.contains(Integer.parseInt(st.nextToken()))) answer.append(1);
            else answer.append(0);
            answer.append("\n");
        }
        
        System.out.print(answer);
    }
}