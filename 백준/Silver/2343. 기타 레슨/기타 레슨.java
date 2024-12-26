import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] lectures;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 처리
        N = scanner.nextInt();
        M = scanner.nextInt();
        lectures = new int[N];
        int maxLectureLength = 0;
        int totalLength = 0;

        for (int i = 0; i < N; i++) {
            lectures[i] = scanner.nextInt();
            maxLectureLength = Math.max(maxLectureLength, lectures[i]);
            totalLength += lectures[i];
        }
        scanner.close();

        // 이분 탐색 초기값
        int L = maxLectureLength; // 최소 크기
        int R = totalLength;      // 최대 크기
        int answer = R;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                answer = mid; // 가능한 경우, 더 작은 값 탐색
                R = mid - 1;
            } else {
                L = mid + 1; // 불가능한 경우, 더 큰 값 탐색
            }
        }

        // 결과 출력
        System.out.println(answer);
    }

    // 결정 함수: limit 크기의 블루레이로 강의를 나눌 수 있는지 확인
    static boolean determination(int limit) {
        int sum = 0, blueRayCount = 1;

        for (int lecture : lectures) {
            if (sum + lecture > limit) { // 현재 블루레이에 담을 수 없으면 새로운 블루레이 시작
                blueRayCount++;
                sum = lecture;

                if (blueRayCount > M) {
                    return false; // 블루레이 개수가 초과되면 불가능
                }
            } else {
                sum += lecture; // 현재 블루레이에 강의 추가
            }
        }
        return true;
    }
}
