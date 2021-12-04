public class Solution {
    public static void main(String[] args) {
        int n = 21;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int inum = i;
            int add = 0;

            while (true) {
                add += inum;

                if (add == n) {
                    answer++;
                    break;
                } else if (add > n) {
                    break;
                }

                inum++;
            }
        }
        return answer;
    }
}
