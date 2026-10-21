import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String target = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        int l = 0, r = 0;
        int answer = 1;

        Map<Character, Integer> map = new HashMap<>();
        map.put(target.charAt(0), 1);

        while (l <= r) {
            char lChar = target.charAt(l);

            if (map.size() > K) {
                if (map.get(lChar) == 1) {
                    map.remove(lChar);
                }
                else {
                    map.put(lChar, map.get(lChar) - 1);
                }

                l++;
            }
            else {
                answer = Math.max(answer, r - l + 1);
                r++;

                if (r < target.length()) {
                    map.put(target.charAt(r), map.getOrDefault(target.charAt(r), 0) + 1);
                }
                else {
                    break;
                }
            }
        }

        System.out.print(answer);
    }
}