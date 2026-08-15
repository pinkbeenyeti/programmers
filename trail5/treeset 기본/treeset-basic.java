import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("add"))
                set.add(Integer.parseInt(st.nextToken()));
            else if (command.equals("remove"))
                set.remove(Integer.parseInt(st.nextToken()));
            else if (command.equals("find"))
                answer.append(set.contains(Integer.parseInt(st.nextToken())) ? "true\n" : "false\n");
            else if (command.equals("lower_bound")) {
                Integer target = set.ceiling(Integer.parseInt(st.nextToken()));
                answer.append(target == null ? "None\n" : target + "\n");
            }
            else if (command.equals("upper_bound")) {
                Integer target = set.higher(Integer.parseInt(st.nextToken()));
                answer.append(target == null ? "None\n" : target + "\n");
            }
            else if (command.equals("largest")) {
                Integer target = set.isEmpty() ? null : set.last();
                answer.append(target == null ? "None\n" : target + "\n");
            }
            else if (command.equals("smallest")) {
                Integer target = set.isEmpty() ? null : set.first();
                answer.append(target == null ? "None\n" : target + "\n");
            }
        }

        System.out.print(answer);
    }
}