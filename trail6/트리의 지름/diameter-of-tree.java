import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static int maxDistance = 0;
    private static int farthestNode = 1; // 가장 먼 노드의 번호를 저장할 변수

    private static class Line {
        int node, value;

        public Line(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String firstLine = br.readLine();
        if (firstLine == null || firstLine.isEmpty()) return;
        
        StringTokenizer st = new StringTokenizer(firstLine);
        int N = Integer.parseInt(st.nextToken());

        List<Line>[] lines = new List[N + 1];
        for (int i = 1; i <= N; i++) lines[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lines[a].add(new Line(b, v));
            lines[b].add(new Line(a, v));
        }

        // [Step 1] 임의의 노드(1번)에서 가장 먼 노드(farthestNode) 찾기
        boolean[] visited = new boolean[N + 1];
        visited[1] = true; // 출발 노드 방문 처리
        dfs(1, 0, lines, visited);

        // [Step 2] 가장 먼 노드에서 다시 DFS를 수행하기 위해 변수 초기화
        maxDistance = 0; 
        visited = new boolean[N + 1];
        
        // 찾은 끝점(farthestNode)에서 다시 가장 먼 노드까지의 거리 구하기
        visited[farthestNode] = true; // 새로운 출발 노드 방문 처리
        dfs(farthestNode, 0, lines, visited);

        // 두 번째 DFS의 결과가 트리의 지름이 됩니다.
        System.out.print(maxDistance);
    }

    private static void dfs(int currentNode, int value, List<Line>[] lines, boolean[] visited) {
        // 현재까지의 거리가 최대 거리보다 크다면 갱신하고 노드 번호 기억
        if (value > maxDistance) {
            maxDistance = value;
            farthestNode = currentNode;
        }

        for (Line next : lines[currentNode]) {
            if (!visited[next.node]) {
                visited[next.node] = true;
                dfs(next.node, value + next.value, lines, visited);
            }
        }
    }
}