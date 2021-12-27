import java.util.*;

public class Solution {
    public static int answer = 0;

    public static void main(String[] args) {
        solution(new int[][]{{10, -1}, {10, 1, -1}, {4, 1, -1}, {4, 3, 1, -1}, {3, 3, -1}}, 5);
    }

    public static void solution(int[][] list, int v) {
        int[] indegree = new int[v + 1];
        int[] time = new int[v + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            indegree[i + 1] = list[i].length - 2;
            time[i + 1] = list[i][0];
            for (int j = 1; j < list[i].length - 1; j++) {
                graph.get(i + 1).add(list[i][j]);
            }
        }

        System.out.println(Arrays.toString(topologySort(indegree, time, graph)));
    }

    public static int[] topologySort(int[] indegree, int[] time, List<List<Integer>> graph) {
        int[] result = Arrays.copyOf(time, time.length);
        Queue<Integer> queue = new LinkedList<>();
        int len = indegree.length;
        int now;

        for (int i = 1; i < len; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            now = queue.poll();
            for (int i : graph.get(now)) {
                System.out.println(now);
                result[i] = Math.max(result[i], result[now] + time[i]);
                indegree[i] -= 1;
                if (indegree[i] == 0) queue.add(i);
            }
        }

        return result;
    }
}