import java.util.*;

class Solution {
    // 1. static 키워드를 제거하여 인스턴스 변수로 변경
    private List<Integer>[] tree;
    private long answer;
    private long[] long_a; // long 타입으로 가중치를 다루기 위한 배열

    public long solution(int[] a, int[][] edges) {
        // 2. 가중치 총합을 미리 long 타입으로 계산
        long sum = 0;
        this.long_a = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            this.long_a[i] = a[i];
        }

        // 3. 총합이 0이 아니면 불가능하므로 즉시 -1 반환
        if (sum != 0) {
            return -1;
        }

        // 4. 인스턴스 변수 초기화
        this.answer = 0;
        this.tree = new ArrayList[a.length];
        for (int i = 0; i < a.length; i++) {
            this.tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        dfs(-1, 0);

        return this.answer;
    }

    private long dfs(int parent, int current) {
        // 자식 노드들이 current 노드로 옮겨온 가중치를 합산할 변수
        long sum = 0;
        int size = tree[current].size();
        
        for (int i=0; i<size; i++) {
            if (tree[current].get(i) != parent) { // 부모 노드로 다시 올라가지 않도록 방지
                sum += dfs(current, tree[current].get(i));
            }
        }

        // 현재 노드의 가중치에 자식들로부터 받은 가중치를 더함
        long totalWeight = this.long_a[current] + sum;
        
        // 이 totalWeight 만큼 부모 노드로 가중치를 옮겨야 함
        // 그 이동 횟수가 바로 비용(answer)
        this.answer += Math.abs(totalWeight);

        // 부모 노드에게 totalWeight를 반환하여 전달
        return totalWeight;
    }
}