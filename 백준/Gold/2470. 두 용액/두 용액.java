import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] liquids;
    static int liquid1, liquid2; // 결과 용액 저장
    static int minDiff = Integer.MAX_VALUE; // 최소 차이 저장

    static void input() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        liquids = new int[N];

        for (int i = 0; i < N; i++) {
            liquids[i] = scanner.nextInt();
        }

        Arrays.sort(liquids); // 오름차순 정렬
    }

    static void binary_search(int startIdx) {
        int L = startIdx + 1;
        int R = N - 1;
        int target = -liquids[startIdx];

        while (L <= R) {
            int mid = (L + R) / 2;
            int sum = liquids[startIdx] + liquids[mid];
            int diff = Math.abs(sum);

            if (diff < minDiff) { // 최소 차이 갱신
                minDiff = diff;
                liquid1 = liquids[startIdx];
                liquid2 = liquids[mid];
            }

            if (sum < 0) {
                L = mid + 1; // 합이 음수면 더 큰 값 탐색
            } else {
                R = mid - 1; // 합이 양수면 더 작은 값 탐색
            }
        }
    }

    static void process() {
        for (int i = 0; i < N - 1; i++) { // 마지막 요소는 탐색할 필요 없음
            binary_search(i);
        }
        System.out.println(liquid1 + " " + liquid2);
    }

    public static void main(String[] args) {
        input();
        process();
    }
}
