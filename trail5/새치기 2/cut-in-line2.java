import java.util.*;
import java.io.*;
 
public class Main {

    private static class Info {
        String name;
        Info prev, next;

        public Info(String n) {
            name = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Map<String, Info> mans = new HashMap<>();
        String prev = "";

        Info[] lines = new Info[M];
        for (int i = 0; i < M; i++) lines[i] = new Info("root");

        for (int i = 1; i <= N; i++) {
            String name = st.nextToken();
            mans.put(name, new Info(name));

            int row = (i - 1) / (N / M);
            int col = (i - 1) % (N / M) + 1;

            Info first = (col == 1) ? lines[row] : mans.get(prev);
            Info second = mans.get(name);

            first.next = second;
            second.prev = first;

            prev = name;
        }

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            String a = st.nextToken();
            String b = (command != 2) ? st.nextToken() : "";
            String c = (command == 3) ? st.nextToken() : "";

            if (command == 1) {
                link(mans.get(b), mans.get(a), mans.get(a));
            } 

            if (command == 2) {
                unLink(mans.get(a), mans.get(a));
            }

            if (command == 3) {
                link(mans.get(c), mans.get(a), mans.get(b));
            }
        }

        for (int i = 0; i < M; i++) {
            Info man = lines[i];

            if (man.next == null) {
                answer.append(-1);
            }
            else {
                while (man.next != null) {
                    answer.append(man.next.name).append(" ");
                    man = man.next;
                }
            }

            answer.append("\n");
        }

        System.out.print(answer);
    }

    private static void link(Info target, Info s, Info e) {
        unLink(s, e);

        s.prev = target.prev;
        target.prev.next = s;

        e.next = target;
        target.prev = e;
    }

    private static void unLink(Info s, Info e) {
        s.prev.next = e.next;
        if (e.next != null) e.next.prev = s.prev;
    }
}