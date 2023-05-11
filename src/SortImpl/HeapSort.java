package SortImpl;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {4, 16, 31, 5, 4, 17, 1, 10, 15, 3, 16, 6, 7, 2, 2, 1, 5, 13, 17, 14, 4, 0};
        int l = arr.length;

        heapSortImpl(arr, l);

        System.out.println(Arrays.toString(arr));
    }

    private static void heapSortImpl(int[] arr, int l) {

        if (l == 0) return;
        /*
         * 1번 노드부터 시작해 부모 노드와 값을 비교하며 정렬한다
         */
        for (int i = 1; i < l; i++) {

            while (i != 0) {

                int parent = (i - 1) / 2;

                if (arr[parent] < arr[i]) {
                    swap(arr, parent, i);
                } else break;

                i = parent;
            }
        }
        /*
         * 정렬이 끝났으면 최상위 노드를 배열 마지막에 채우고 재귀호출
         */
        swap(arr, 0, l - 1);

        heapSortImpl(arr, l - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}