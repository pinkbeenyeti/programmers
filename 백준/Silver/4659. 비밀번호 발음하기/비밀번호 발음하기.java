import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {
    private static Set<Character> vowels;
    private static StringBuilder answer;

    private static void isValid(String password) {
        // 1. 모음(a,e,i,o,u)이 하나라도 있는지 먼저 확인
        if (!password.contains("a") && !password.contains("e") && !password.contains("i") && !password.contains("o") && !password.contains("u")) {
            answer.append("<").append(password).append("> is not acceptable.\n");
            return;
        }

        int seVowel = 0; // 연속 모음 개수
        int seCon = 0;   // 연속 자음 개수

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            // 2. 모음/자음 연속 개수 확인
            if (vowels.contains(ch)) {
                seVowel++;
                seCon = 0;
            } else {
                seCon++;
                seVowel = 0;
            }

            if (seVowel >= 3 || seCon >= 3) {
                answer.append("<").append(password).append("> is not acceptable.\n");
                return;
            }

            // 3. 같은 글자 연속 확인 (i > 0 조건으로 첫 글자는 제외)
            if (i > 0) {
                char prevChar = password.charAt(i - 1);
                if (ch == prevChar) {
                    if (ch != 'e' && ch != 'o') {
                        answer.append("<").append(password).append("> is not acceptable.\n");
                        return;
                    }
                }
            }
        }

        // 모든 조건을 통과한 경우
        answer.append("<").append(password).append("> is acceptable.\n");
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

        // 혹시 모를 출력 형식 오류를 방지하기 위해 print 사용
        System.out.print(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}