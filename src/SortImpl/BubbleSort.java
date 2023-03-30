package SortImpl;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {4, 2, 5, 4, 3, 1, 10, 3};

       bubbleSortImpl(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSortImpl(int[] arr) {

        for (int i = 1; i < arr.length; i++) { // 배열 길이보다 하나 적은 횟수만큼 반복

            for (int j = 0; j < arr.length - 1; j++) { // 비교 횟수도 마찬가지로 하나 작음

                if (arr[j] > arr[j + 1]) { // 비교 후 자리바꿈

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}