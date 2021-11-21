package practice.dfsAndBfs.taravelRoute;

import java.util.Arrays;
import java.util.Objects;

public class TravelRoute {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(Arrays.toString(getRoute(tickets, new String[tickets.length + 1], new int[tickets.length + 1], 0)));
    }

    /**
     * To find Most Efficient Travel Route for User.
     * To solve this problem. I will Use Recursive Function.
     *
     * @param tickets Tickets What User got
     * @param route   Route What User will get
     * @param n       Index of Tickets
     * @return Travel Route for User ( String[] )
     */
    public static String[] getRoute(String[][] tickets, String[] route, int[] visited, int n) {
        if (tickets.length == n) {
            return route;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (n == 0 && "ICN".equals(tickets[n][0])) {
                route[n] = tickets[i][0];

            } else if (n > 0) {
                int finalI = i;
                if (Arrays.stream(visited).anyMatch(item -> item == finalI)) continue;
                if (route[n - 1].equals(tickets[n][0])) {
                    route[n] = tickets[i][1];
                }
            }
        }

        return getRoute(tickets, route, visited, n + 1);
    }
}
