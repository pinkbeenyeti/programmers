import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    private static String term;
    private static int[] count;

    private static int answerCount = -1, charCount = 0;
    private static char answer;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        term = st.nextToken().toLowerCase();
        count = new int['z' - 'a' + 1];
    }

    private static void process() {
        for (int i=0; i<term.length(); i++) {
            count[term.charAt(i) - 'a']++;
        }

        for (int i=0; i<26; i++) {
            if (count[i] > answerCount) {
                charCount = 0;
                answerCount = count[i];
                answer = (char) ('A' + i);
            }

            if (answerCount == count[i]) {
                charCount++;
            }
        }

        if (charCount > 1) {
            System.out.println("?");
        } else {
            System.out.println(answer);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
