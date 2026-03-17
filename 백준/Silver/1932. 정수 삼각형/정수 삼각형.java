import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i=1; i<=N; i++) {
            int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            list.add(array);
        }

        for (int i=(N - 1); i>0; i--) {
            int[] bottom = list.get(i);
            int[] upper = list.get(i - 1);

            for (int j=0; j<upper.length; j++) {
                upper[j] += Math.max(bottom[j], bottom[j + 1]);
            }
        }

        System.out.print(list.get(0)[0]);
    }
}
