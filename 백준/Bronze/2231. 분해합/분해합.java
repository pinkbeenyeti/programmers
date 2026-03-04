import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i=1; i<=N; i++) {
            int target = i, sum = 0;

            while (target > 0) {
                sum += target % 10;
                target = target / 10;
            }

            if ((sum + i) == N) {
                answer = i;
                break;
            }
        }
        
        System.out.print(answer);
    }
}
