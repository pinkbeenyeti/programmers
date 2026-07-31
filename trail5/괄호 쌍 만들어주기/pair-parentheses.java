import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        long answer = 0;

        int[] lefts = new int[target.length()];
        int[] rights = new int[target.length()];

        for (int i = 1; i < target.length(); i++) {
            int currentChar = target.charAt(i);
            int prevChar = target.charAt(i - 1);

            if (currentChar == prevChar) {
                if (currentChar == '(') {
                    lefts[i] = lefts[i - 1] + 1;
                    rights[i] = rights[i - 1];
                }
                else {
                    lefts[i] = lefts[i - 1];
                    rights[i] = rights[i - 1] + 1;
                    answer += lefts[i];
                };
            }

            if (currentChar != prevChar) {
                lefts[i] = lefts[i - 1];
                rights[i] = rights[i - 1];
            }
        }

        System.out.print(answer);
    }
}