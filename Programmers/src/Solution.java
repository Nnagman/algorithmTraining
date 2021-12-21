import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution(5, 7, new int[][]{{1, 2}, {1, 3}, {1, 4}, {2, 4}, {3, 4}, {3, 5}, {4, 5}}, 4, 5));
    }

    public static int solution(int n, int m, int[][] list, int x, int k) {
        int answer = 0;

        int[][] graph = floydWarshall(n, m, list);

        System.out.println(Arrays.deepToString(graph));

        return answer;
    }

    public static int[][] floydWarshall(int n, int m, int[][] list) {
        int graph[][] = new int[n][n];

        for (int a = 0; a < m; a++) {
            graph[list[a][0]-1][list[a][1]-1] = 1;
            graph[list[a][1]-1][list[a][0]-1] = 1;
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (a != b && graph[a][b] == 0) {
                    graph[a][b] = Integer.MAX_VALUE;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        return graph;
    }
}