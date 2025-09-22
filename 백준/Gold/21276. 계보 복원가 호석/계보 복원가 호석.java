import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static List<String> nodes;
    private static Map<String, PriorityQueue<String>> childCount;
    private static Map<String, List<String>> ancestors;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nodes = new ArrayList<>();
        childCount = new HashMap<>();
        ancestors = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            String node = st.nextToken();

            nodes.add(node);
            childCount.put(node, new PriorityQueue<>());
            ancestors.put(node, new ArrayList<>());
        }

        M = Integer.parseInt(br.readLine());

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken(), parent = st.nextToken();

            ancestors.get(child).add(parent);
        }
    }

    private static void process() {
        List<String> roots = new ArrayList<>();


        for (String key : ancestors.keySet()) {
            if (ancestors.get(key).isEmpty()) {
                roots.add(key);
                continue;
            }

            for (String ancestor : ancestors.get(key)) {
                if (ancestors.get(key).size() == (ancestors.get(ancestor).size() + 1)) {
                    childCount.get(ancestor).offer(key);
                    break;
                }
            }
        }

        Collections.sort(roots);
        Collections.sort(nodes);

        StringBuilder sb = new StringBuilder();
        System.out.println(roots.size());

        for (String root : roots) {
            sb.append(root).append(" ");
        }

        System.out.println(sb.toString());

        for (String node : nodes) {
            sb = new StringBuilder();
            sb.append(node).append(" ").append(childCount.get(node).size()).append(" ");

            for (String child : childCount.get(node)) {
                sb.append(child).append(" ");
            }

            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
