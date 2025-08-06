import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main  {
    private static int N, M;
    private static int[] praises = new int[100_001];
    private static List<Integer>[] supervisors = new List[100_001];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (number == -1) {
                continue;
            }

            if (supervisors[number] == null) {
                supervisors[number] = new ArrayList<>();
            }

            supervisors[number].add(i + 1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer((br.readLine()));
            int number = Integer.parseInt(st.nextToken());
            int praise = Integer.parseInt(st.nextToken());
            praises[number] += praise;
        }
    }

    private static void dfs(int supervisor) {
        // 직속 부하가 있는 경우, 그들에게 칭찬을 전파합니다.
        if (supervisors[supervisor] != null) {
            for (int employee : supervisors[supervisor]) {
                praises[employee] += praises[supervisor];
                dfs(employee);
            }
        }
    }

    private static void process() {
        dfs(1);

        for (int i = 1; i <= N; i++) {
            System.out.print(praises[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
