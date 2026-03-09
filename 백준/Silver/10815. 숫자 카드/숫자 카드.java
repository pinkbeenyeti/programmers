import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    
    private static Set<Integer> cards = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<N; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<M; i++) {
            if (cards.contains(Integer.parseInt(st.nextToken()))) answer.append(1);
            else answer.append(0);
            
            answer.append(" ");
        }
        
        System.out.print(answer);
    }

}
