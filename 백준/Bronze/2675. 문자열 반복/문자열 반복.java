import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String[] target = br.readLine().split(" ");
            int count = Integer.parseInt(target[0]);

            for (int j=0; j<target[1].length(); j++) {
                answer.append(target[1].substring(j, j + 1).repeat(count));
            }

            answer.append("\n");
        }

        System.out.print(answer);
    }
}
