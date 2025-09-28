import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static Set<Integer> set = new HashSet<>();;
    private static StringBuilder sb = new StringBuilder();

    private static void doCommand(String command, int number) {
        if (command.equals("add")) {
            set.add(number);
            return;
        }

        if (command.equals("remove")) {
            set.remove(number);
            return;
        }

        if (command.equals("check")) {
            sb.append((set.contains(number)) ? 1 : 0).append("\n");
            return;
        }

        if (command.equals("toggle")) {
            if (set.contains(number)) set.remove(number);
            else set.add(number);

            return;
        }

        if (command.equals("all")) {
            set.clear();

            for (int i=1; i<=20; i++) {
                set.add(i);
            }

            return;
        }

        if (command.equals("empty")) {
            set.clear();
        }
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            String[] command = br.readLine().split(" ");
            doCommand(command[0], (command.length > 1) ? Integer.parseInt(command[1]) : 0);
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
