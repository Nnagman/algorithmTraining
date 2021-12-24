import java.util.*;

public class Solution {
    public static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{3, 2, 1}, {1, 2, 4}, {1, 3, 2}}));
    }

    public static int solution(int[][] list) {
        int answer = 0;

        int n = list[0][0];
        int m = list[0][1];
        int c = list[0][2];

        int[] distance = new int[n + 1];

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < m + 1; i++) {
            graph.get(list[i][0]).add(new int[]{list[i][1], list[i][2]});
        }

        dijkstra(distance, graph, c);

        int[] result = new int[2];

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] != Integer.MAX_VALUE && distance[i] != 0
            ) {
                result[0] += 1;
                result[1] = Math.max(result[1], distance[i]);
            }
        }

        System.out.println(Arrays.toString(result));

        return answer;
    }

    public static int[] dijkstra(int[] distance, List<List<int[]>> graph, int start) {
        int cost;

        PriorityQueue<int[]> heapQueue = new PriorityQueue<>(Comparator.comparing((o1) -> o1[1]));

        heapQueue.add(new int[]{0, start});
        distance[start] = 0;

        while (!heapQueue.isEmpty()) {
            int[] node = heapQueue.poll();
            int now = node[1];
            int dist = node[0];

            if (distance[now] < dist) continue;

            for (int[] i : graph.get(now)) {
                cost = i[1] + dist;

                if (cost < distance[i[0]]) {
                    distance[i[0]] = cost;
                    heapQueue.add(new int[]{cost, i[0]});
                }
            }
        }

        System.out.println(Arrays.toString(distance));

        return distance;
    }
}