import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = Integer.MIN_VALUE;
        int l = 0;

        int[] nums = new int[N];
        boolean[] isExist = new boolean[1_000_001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int r = 0; r < N; r++) {
            if (!isExist[nums[r]]) {
                answer = Math.max(answer, r - l + 1);
                isExist[nums[r]] = true;
                continue;
            }

            while (l <= r) {
                if (nums[l] != nums[r]) isExist[nums[l]] = false;
                else {
                    l++;
                    break;
                }

                l++;
            }
        }

        System.out.print(answer);
    }
}