import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    
    private static int N, M;
    private static int[] baskets;

    public static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        baskets = new int[N + 1];
        
        for (int i=1; i<=N; i++) {
            baskets[i] = i;
        }
        
        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = baskets[a];
            
            baskets[a] = baskets[b];
            baskets[b] = temp;
        }
        
        for (int i=1; i<=N; i++) {
            answer.append(baskets[i]).append(" ");
        }
        
        System.out.print(answer);
    }

    public static void main(String[] args) throws IOException {
        process();
    }
}
