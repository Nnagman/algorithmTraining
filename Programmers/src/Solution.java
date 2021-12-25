import java.util.*;

public class Solution {
    public static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 6}, {3, 4}, {4, 7}, {5, 6}, {6, 4}}, 7));
    }

    public static List<Integer> solution(int[][] list, int v) {
        int[] indegree = new int[v + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] ints : list) {
            indegree[ints[1]] += 1;
            graph.get(ints[0]).add(ints[1]);
        }

        return topologySort(indegree, graph);
    }

    public static List<Integer> topologySort(int[] indegree, List<List<Integer>> graph) {
        List<Integer> result = new ArrayList<>();
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
            result.add(now);
            for (int i : graph.get(now)) {
                indegree[i] -= 1;
                if (indegree[i] == 0) queue.add(i);
            }
        }

        return result;
    }
}