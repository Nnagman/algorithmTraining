public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(4, 6, new int[]{19, 15, 10, 17}));
    }

    public static int solution(int n, int m, int[] cakes) {
        quick_sort(0, n - 1, cakes);

        int total, mid, answer = 0;
        int start = 0;
        int end = cakes[n - 1];

        while (start <= end) {
            total = 0;
            mid = (start + end) / 2;

            for (int cake : cakes) {
                if (cake > mid) {
                    total += cake - mid;
                }
            }
            if (total < m) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }

        return answer;
    }

    public static void quick_sort(int start, int end, int[] arr) {
        if (start >= end) return;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= arr[start]) {
                left++;
            }

            while (start < right && arr[start] <= arr[right]) {
                right--;
            }

            if (right < left) {
                int temp = arr[start];
                arr[start] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }

        quick_sort(start, right - 1, arr);
        quick_sort(right + 1, end, arr);
    }

    public static int binary_search_recursive(int start, int end, int target, int[] arr) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return binary_search_recursive(start, mid - 1, target, arr);
        } else {
            return binary_search_recursive(mid + 1, end, target, arr);
        }
    }

    public static int binary_search_loop(int start, int end, int target, int[] arr) {
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int[] counting_sort(int n, int[] items) {
        int[] arr = new int[n];

        for (int item : items) {
            arr[item] = 1;
        }

        return arr;
    }
}