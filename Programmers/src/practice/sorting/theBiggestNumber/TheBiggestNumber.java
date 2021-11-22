package practice.sorting.theBiggestNumber;

import java.util.Arrays;
import java.util.List;

public class TheBiggestNumber {
    public static void main(String[] args) {

    }

    public static String solution(int[] numbers) {
        List<Integer> list = Arrays.stream(numbers).boxed().toList();
        return getAnswer(list, "");
    }

    public static String getAnswer(List<Integer> numbers, String answer) {
        if (numbers.size() == 0) return answer;

        int temp = 0;

        for (int number : numbers) {
            temp = getBiggerNumber(temp, number, 0);
        }

        numbers.remove(temp);

        return getAnswer(numbers, answer + temp);
    }

    public static int getBiggerNumber(int target1, int target2, int n) {
        if (target1 == 0 || target1 == target2) return target2;
        if (target2 == 0) return target1;

        if (n == Integer.toString(target1).length()) return target1;

        int temp1 = Integer.parseInt(Integer.toString(target1).substring(n, n + 1));
        int temp2 = Integer.parseInt(Integer.toString(target2).substring(n, n + 1));

        if (temp1 > temp2) return target1;
        else if (temp1 < temp2) return target2;

        return getBiggerNumber(target1, target2, n + 1);
    }
}
