import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int set = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());;

            String command = st.nextToken();

            if (command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set |= 1 << x;
            }

            if (command.equals("delete")) {
                int x = Integer.parseInt(st.nextToken());
                set &= ~(1 << x);
            }

            if (command.equals("print")) {
                int x = Integer.parseInt(st.nextToken());
                if ((set & (1 << x)) == (1 << x)) answer.append("1\n");
                else answer.append("0\n");
            }

            if (command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if ((set & (1 << x)) == (1 << x)) set ^= (1 << x);
                else set |= 1 << x;
            }

            if (command.equals("clear")) {
                set = 0;
            }
        }
        
        System.out.print(answer);
    }
}