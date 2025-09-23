import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static String A, B;
    private static Map<Long, Integer> transformedMap;
    private static List<long[]> results;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = st.nextToken();

        transformedMap = new HashMap<>();
        results = new ArrayList<>();
    }

    private static void process() {
        for (int formation = 2; formation <= 36; formation++) {
            boolean flag = false;
            long result = 0;

            for (int index = (A.length() - 1); index >= 0; index--) {
                char ch = A.charAt(index);

                if (!checkFormation(ch, formation)) {
                    break;
                }

                if (result > Long.MAX_VALUE - transform(ch, A.length() - index - 1, formation)) {
                    break;
                }

                result += transform(ch, A.length() - index - 1, formation);
                flag = true;
            }

            if (flag) {
                transformedMap.put(result, formation);
            }
        }


        for (int formation = 2; formation <= 36; formation++) {
            boolean flag = false;
            long result = 0;

            for (int index = (B.length() - 1); index >= 0; index--) {
                char ch = B.charAt(index);

                if (!checkFormation(ch, formation)) {
                    break;
                }

                if (result > Long.MAX_VALUE - transform(ch, A.length() - index - 1, formation)) {
                    break;
                }

                result += transform(ch, B.length() - index - 1, formation);
                flag = true;
            }

            if (flag && transformedMap.containsKey(result) && transformedMap.get(result) != formation) {
                results.add(new long[]{result, transformedMap.get(result), formation});

                if (results.size() > 1) break;
            }
        }

        if (results.isEmpty()) System.out.println("Impossible");
        else if (results.size() > 1) System.out.println("Multiple");
        else {
            long[] result = results.get(0);
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
        }
    }

    private static boolean checkFormation(char ch, int formation) {
        if (ch >= '0' && ch <= '9') {
            return (ch - '0') <= (formation - 1);
        }

        return (ch - 'a' + 10) <= (formation - 1);
    }

    private static long transform(char ch, int index, int formation) {
        if (ch >= '0' && ch <= '9') {
            return (ch - '0') * (long) Math.pow(formation, index);
        }

        return (ch - 'a' + 10) * (long) Math.pow(formation, index);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
