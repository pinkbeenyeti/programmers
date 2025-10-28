import java.util.*;

class Solution {
    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Node>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new LinkedList<>();

        for (int[] path : paths) {
            graph[path[0]].add(new Node(path[1], path[2]));
            graph[path[1]].add(new Node(path[0], path[2]));
        }

        Set<Integer> gateSet = new HashSet<>();
        Set<Integer> summitSet = new HashSet<>();
        for (int g : gates) gateSet.add(g);
        for (int s : summits) summitSet.add(s);

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        for (int gate : gates) {
            intensity[gate] = 0;
            pq.offer(new int[]{gate, 0});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0], cost = cur[1];
            
            if (summitSet.contains(now) || intensity[now] < cost) continue;
            
            for (Node next : graph[now]) {
                if (gateSet.contains(next.to)) continue;
                
                int newIntensity = Math.max(cost, next.weight);
                if (intensity[next.to] > newIntensity) {
                    intensity[next.to] = newIntensity;
                    pq.offer(new int[]{next.to, newIntensity});
                }
            }
        }

        int minSummit = 0, minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minIntensity = intensity[summit];
                minSummit = summit;
            }
        }

        return new int[]{minSummit, minIntensity};
    }
}
