import java.io.*;
import java.util.*;

public class Main {

    private static class Problem implements Comparable<Problem> {
        int num, hard;

        public Problem(int num, int hard) {
            this.num = num;
            this.hard = hard;
        }

        @Override
        public int compareTo(Problem other) {
            if (this.hard == other.hard) return Integer.compare(this.num, other.num);
            return Integer.compare(this.hard, other.hard);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        
        TreeSet<Problem> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            set.add(new Problem(a, b));
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("rc")) {
                int x = Integer.parseInt(st.nextToken());
                Problem problem = x == 1 ? set.last() : set.first();
                answer.append(problem.num).append("\n");
            }
            else if (command.equals("ad")) {
                int num = Integer.parseInt(st.nextToken());
                int hard = Integer.parseInt(st.nextToken());
                set.add(new Problem(num, hard));
            }
            else {
                int num = Integer.parseInt(st.nextToken());
                int hard = Integer.parseInt(st.nextToken());
                set.remove(new Problem(num, hard));
            }
        }

        System.out.print(answer);
    }
}