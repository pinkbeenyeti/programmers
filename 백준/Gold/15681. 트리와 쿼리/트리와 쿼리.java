import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, R, Q;
    static int[] childCount = new int[100001];
    static List<Integer>[] tree = new List[100001];
    static List<Integer>[] linkedList = new List[100001];
    static List<Integer> queryList = new ArrayList<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            linkedList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());

            linkedList[U].add(V);
            linkedList[V].add(U);
        }

        for (int i = 0; i < Q; i++) {
            queryList.add(Integer.parseInt(br.readLine()));
        }

        br.close();
    }

    static int getTree(int parent) {
        tree[parent] = new ArrayList<>();
        int count = 1;

        for (int child : linkedList[parent]) {
            if (tree[child] == null) {
                tree[parent].add(child);
                count += getTree(child);
            }
        }

        childCount[parent] = count;
        return count;
    }

    static void process() {
        getTree(R);

        for (int i = 0; i < Q; i++) {
            System.out.println(childCount[queryList.get(i)]);
        }
    }



    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
