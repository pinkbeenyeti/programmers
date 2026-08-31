import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = 0;

        String[] B = new String[N + 1];

        int[] SL = new int[N + 2];
        int[] SR = new int[N + 2];

        int[] HL = new int[N + 2];
        int[] HR = new int[N + 2];

        int[] PL = new int[N + 2];
        int[] PR = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            B[i] = br.readLine().trim();

            SL[i] = SL[i - 1];
            HL[i] = HL[i - 1];
            PL[i] = PL[i - 1];

            if (B[i].equals("S")) 
                HL[i]++;
            else if (B[i].equals("H"))
                PL[i]++;
            else if (B[i].equals("P")) 
                SL[i]++;
        }

        for (int i = N; i >= 1; i--) {
            SR[i] = SR[i + 1];
            HR[i] = HR[i + 1];
            PR[i] = PR[i + 1];

            if (B[i].equals("S")) 
                HR[i]++;
            else if (B[i].equals("H")) 
                PR[i]++;
            else if (B[i].equals("P")) 
                SR[i]++;
        }

        for (int i = 1; i <= N + 1; i++) {
            answer = Math.max(answer, SL[i - 1] + HR[i]);
            answer = Math.max(answer, SL[i - 1] + PR[i]);
            answer = Math.max(answer, HL[i - 1] + SR[i]);
            answer = Math.max(answer, HL[i - 1] + PR[i]);
            answer = Math.max(answer, PL[i - 1] + SR[i]);
            answer = Math.max(answer, PL[i - 1] + HR[i]);

            answer = Math.max(answer, SL[i - 1] + SR[i]);
            answer = Math.max(answer, HL[i - 1] + HR[i]);
            answer = Math.max(answer, PL[i - 1] + PR[i]);
        }

        System.out.print(answer);
    }
}