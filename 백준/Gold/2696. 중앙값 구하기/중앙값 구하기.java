import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine()), middle = 0;
            List<Integer> list = new ArrayList<>();

            StringBuilder tAnswer = new StringBuilder();
            st = new StringTokenizer(br.readLine());

            for (int j=1; j<=N; j++) {
                if (j != 1 && j % 10 == 1) {
                    st = new StringTokenizer(br.readLine());
                }

                int number = Integer.parseInt(st.nextToken());
                list.add(number);

                if (j % 2 == 1) {
                    Collections.sort(list);
                    middle++;

                    if (middle % 10 == 0) tAnswer.append(list.get(j/2)).append("\n");
                    else tAnswer.append(list.get(j/2)).append(" ");
                }
            }

            answer.append(middle).append("\n").append(tAnswer).append("\n");
        }

        System.out.print(answer);
    }
}
