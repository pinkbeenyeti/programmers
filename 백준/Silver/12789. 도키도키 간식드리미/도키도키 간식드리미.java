import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static Queue<Integer> qu = new LinkedList<>();
    private static Stack<Integer> stack = new Stack<>();
    private static boolean canSnack = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()), index = 1;
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            qu.offer(Integer.parseInt(st.nextToken()));
        }

        while (!qu.isEmpty()) {
            if (qu.peek() != index) stack.push(qu.poll());
            else {
                qu.poll();
                index++;
            }
            
            while (!stack.isEmpty() && stack.peek() == index) {
                stack.pop();
                index++;
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == index) {
                stack.pop();
                index++;
            } else {
                canSnack = false;
                break;
            }
        }

        if (canSnack) System.out.print("Nice");
        else System.out.print("Sad");
    }
}