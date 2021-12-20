import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 5}, 15));
    }

    public static int solution(int[] n, int m) {
        int[] d = new int[10001];
        int len = d.length;

        for (int i = 0; i < len + 1; i++) {
            for (int x : n) {
                if (d[i + x] == 0)
                    d[i + x] = d[i] + 1;
            }
            if (d[m] > 0) break;
        }

        return d[m] > 0 ? d[m] : -1;
    }

    public static void floydWarshall(int n, int[][] arr) {
        int[][] graph = new int[n][n];

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (a == b) graph[a][b] = 0;
                else graph[a][b] = Integer.MAX_VALUE;
            }
        }

        for (int[] i : arr) {
            graph[i[0]][i[1]] = i[2];
        }

        for (int k = 0; k < n; k++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
    }
}