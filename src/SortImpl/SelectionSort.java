package SortImpl;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {4, 16, 31, 5, 4, 17, 1, 10, 15, 3, 16, 6, 7, 2, 2, 1, 5, 13, 17, 14, 4, 0};

        selectionSortImpl(arr);

        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSortImpl(int[] arr) {

        for (int i = 0; i < arr.length - 1 ; i++) { // 0번 인덱스에서 시작

            int min = arr[i]; // 처음 값을 최솟값에 넣어둠
            int minIdx = i; // 마찬가지로 처음 인덱스를 최솟값 인덱스에 넣어둠

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < min)  {
                    min = arr[j]; // i 번째 원소가 더 작으면 저장
                    minIdx = j;
                }
            }
            int tmp = arr[i]; // 한 바퀴 다 돌면 스왑
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }
    }
}