package practice.dfsAndBfs.taravelRoute;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TravelRoute {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        String[] route = new String[tickets.length + 1];
        int[] visited = new int[tickets.length];

        String start = "";
        int startIdx = 0;

        for (int i = 0; i < tickets.length; i++) {
            if ("ICN".equals(tickets[i][0])) {
                if (checkAlphabet(start, tickets[i][1])) {
                    start = tickets[i][1];
                    startIdx = i;
                }
            }
        }

        route[0] = tickets[startIdx][0];
        route[1] = tickets[startIdx][1];
        visited[startIdx] = 1;

        System.out.println(Arrays.toString(getRoute(tickets, route, visited, 2, startIdx)));
    }

    public static String[] getRoute(String[][] tickets, String[] route, int[] visited, int n, int startIdx) {
        System.out.println(Arrays.toString(route) + " " + Arrays.toString(visited) + " " + n + " " + startIdx + " " + Arrays.toString(tickets[startIdx]));
        if (n == tickets.length + 1) return route;

        String start = tickets[startIdx][1];
        String destination = "";

        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && visited[i] != 1) {
                if (checkAlphabet(destination, tickets[i][1])) {
                    startIdx = i;
                    destination = tickets[i][1];
                }
            }
        }

        route[n] = tickets[startIdx][1];
        visited[startIdx] = 1;

        return getRoute(tickets, route, visited, n + 1, startIdx);
    }

    public static boolean checkAlphabet(String s1, String s2) {
        if ("".equals(s1)) return true;

        byte[] bytes1 = s1.getBytes(StandardCharsets.US_ASCII);
        byte[] bytes2 = s2.getBytes(StandardCharsets.US_ASCII);

        for (int i = 0; i < bytes1.length; i++) {
            if (bytes1[i] < bytes2[i]) return false;
            else if (bytes1[i] > bytes2[i]) return true;
        }

        return false;
    }
}
