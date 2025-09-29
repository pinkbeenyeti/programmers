import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Set;

public class Main {
    private static Set<Character> vowels;
    private static StringBuilder answer;

    private static void isValid(String password) {
        int seCon = 0, seVowel = 0, vowelCount = 0;
        boolean includeVowel = false;
        char prevChar = 'A';

        for (char ch : password.toCharArray()) {
            if (prevChar == ch && prevChar != 'e' && prevChar != 'o') {
                answer.append("<").append(password).append("> is not acceptable.\n");
                return;
            }

            if (vowels.contains(ch)) {
                includeVowel = true;
                seVowel++;
                seCon = 0;
            } else {
                seCon++;
                seVowel = 0;
            }

            if (seCon >= 3 || seVowel >= 3) {
                answer.append("<").append(password).append("> is not acceptable.\n");
                return;
            }

            prevChar = ch;
        }

        if (!includeVowel) {
            answer.append("<").append(password).append("> is not acceptable.\n");
        } else {
            answer.append("<").append(password).append("> is acceptable.\n");
        }
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        vowels = Set.of('a', 'e', 'i', 'o', 'u');
        answer = new StringBuilder();

        while (true) {
            String password = br.readLine();

            if (password.equals("end")) {
                break;
            }

            isValid(password);
        }

        System.out.print(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
