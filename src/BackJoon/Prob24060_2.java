package BackJoon;

import java.util.Scanner;

public class Prob24060_2 {

    private static int[] temp;
    private static int k;
    private static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[a];
        temp = new int[a];

        for (int i = 0; i < a; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSortImpl(arr, 0, a - 1);

        System.out.println(-1);
    }

    public static void mergeSortImpl(int[] arr, int start, int end) {

        if (start == end) return; // 끝까지 쪼개면 리턴

        int mid = (start + end) / 2; // 절반으로 나누기

        mergeSortImpl(arr, start, mid); // 왼쪽 절반 재귀호출
        mergeSortImpl(arr, mid + 1, end); // 오른쪽 절반 재귀호출

        mergeSort(arr, start, mid, end);
    }

    private static void mergeSort(int[] arr, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int idx = left;
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right])
                temp[idx++] = arr[left++];
            else
                temp[idx++] = arr[right++];
        }
        while (left <= mid)
            temp[idx++] = arr[left++];
        while (right <= end)
            temp[idx++] = arr[right++];
        left = start;
        idx = left;
        while (left <= end) {
            arr[left++] = temp[idx++];
            cnt++;
            if (cnt == k) {
                System.out.println(arr[left - 1]);
                System.exit(0);
            }
        }
    }
}