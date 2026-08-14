import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            if (command.equals("add")) set.add(x);
            else if (command.equals("remove")) set.remove(x);
            else {
                if (set.contains(x)) answer.append("true");
                else answer.append("false");
                answer.append("\n");
            }
        }

        System.out.print(answer);
    }
}