package practice.heap.diskController;

import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] job : jobs) {
            pq.add(job[0] + job[0] + job[1]);
        }

        while (!pq.isEmpty()) {

            answer = answer + (answer + pq.poll());
            System.out.println(answer);
        }

        return (answer - 1) / jobs.length;
    }
}
