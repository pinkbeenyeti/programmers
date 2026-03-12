import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static long[][] A;
    private static long[][] result;

    private static void multiply(long[][] a, long[][] b, int N) {
        long[][] temp = new long[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                for (int k=0; k<N; k++) {
                    temp[k][i] += a[k][j] * b[j][i];
                    temp[k][i] = temp[k][i] % 1000;
                }
            }
        }

        result = temp;
    }

    private static void pow(int N, long size) {
        if (size == 1) {
            return;
        }

        pow(N, size/2);
        multiply(result, result, N);

        if (size % 2 == 1) {
            multiply(result, A, N);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        A = new long[N][N];
        result = new long[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                A[i][j] = Long.parseLong(st.nextToken()) % 1000;
                result[i][j] = A[i][j];
            }
        }

        pow(N, B);

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                answer.append(result[i][j]).append(" ");
            }

            answer.append("\n");
        }

        System.out.print(answer);
    }
}
