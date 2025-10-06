import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(), answer = "";
        
        for (char ch : input.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                answer += (char) (ch + ('A' - 'a'));
            } else {
                answer += (char) (ch - ('A' - 'a'));
            }
        }
        
        System.out.println(answer);
    }
}