package practice.greedy.connectingIslands;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectingIslands {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int len = costs.length;
        int child, parent;
        int[] arr = new int[n];

        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        answer += costs[0][2];
        if (costs[0][0] > costs[0][1]) {
            arr[costs[0][0]] = costs[0][1];
            arr[costs[0][1]] = costs[0][1];
        } else {
            arr[costs[0][1]] = costs[0][0];
            arr[costs[0][0]] = costs[0][0];
        }

        for (int i = 1; i < len - 1; i++) {
            if (costs[i][0] > costs[i][1]) {
                parent = costs[i][1];
                child = costs[i][0];
            } else {
                parent = costs[i][0];
                child = costs[i][1];
            }

            // check has same root
            while (true) {
                if (child == arr[child]) {
                    break;
                }
                child = arr[child];
            }

            if (child != parent) {
                arr[costs[i][1]] = parent;
                answer += costs[i][2];
            }
        }

        return answer;
    }
}
