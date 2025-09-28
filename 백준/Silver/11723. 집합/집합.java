import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int S = 0;
    private static StringBuilder sb = new StringBuilder();

    private static void doCommand(String command, int bitNumber) {
        if (command.equals("empty")) {
            S = 0;
            return;
        }

        if (command.equals("all")) {
            S = (1 << 21) - 1;
            return;
        }

        if (command.equals("toggle")) {
            S = S ^ bitNumber;
            return;
        }

        if (command.equals("check")) {
            sb.append((S & bitNumber) != 0 ? 1 : 0).append("\n");
            return;
        }

        if (command.equals("remove")) {
            if ((S & bitNumber) != 0) {
                S = S ^ bitNumber;
            }
        }

        if (command.equals("add")) {
            S = S | bitNumber;
        }
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            String[] command = br.readLine().split(" ");
            doCommand(command[0], (command.length > 1) ? 1 << Integer.parseInt(command[1]) : 0);
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
