import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            TreeSet<Integer> set = new TreeSet<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                String command = st.nextToken();
                int x = Integer.parseInt(st.nextToken());

                if (command.equals("I")) 
                    set.add(x);
                else {
                    if (x == 1) {
                        if (!set.isEmpty()) set.remove(set.last());
                    }
                    else {
                        if (!set.isEmpty()) set.remove(set.first());
                    }
                }
            }

            if (!set.isEmpty()) 
                answer.append(set.last() + " " + set.first()).append("\n");
            else 
                answer.append("EMPTY").append("\n");
        }

        System.out.print(answer);
    }
}