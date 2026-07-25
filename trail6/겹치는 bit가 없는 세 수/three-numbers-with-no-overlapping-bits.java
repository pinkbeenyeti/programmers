import java.io.*;
import java.util.*;

public class Main {

    private static int answer = 0;
    private static int[] nums;
    private static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        selected = new int[3];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.print(answer);
    }

    private static void dfs(int start, int index) {
        if (index == 3) {
            int a = selected[0] & selected[1];
            int b = selected[0] & selected[2];
            int c = selected[1] & selected[2];

            if (a == 0 && b == 0 && c == 0) {
                answer = Math.max(answer, selected[0] + selected[1] + selected[2]);
            }

            return;
        }

        for (int i = start; i < nums.length; i++) {
            selected[index] = nums[i];
            dfs(i + 1, index + 1);
        }
    }
}