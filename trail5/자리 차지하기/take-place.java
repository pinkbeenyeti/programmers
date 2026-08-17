import java.io.*;
import java.util.*;

public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int count = 0;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 1; i <= N; i++) {
            set.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            Integer seat = set.floor(Integer.parseInt(st.nextToken()));

            if (seat != null) {
                set.remove(seat);
                count++;
            } else{
                break;
            }
        }

        System.out.print(count);
    }
}