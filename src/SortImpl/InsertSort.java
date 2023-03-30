package SortImpl;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {4, 2, 5, 4, 3, 1, 10, 3};

        insertSortImpl(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void insertSortImpl(int[] arr) {

        for (int i = 1; i < arr.length; i++) { // 1번 인덱스에서 시작

            int temp = arr[i];

            int j = i - 1; // 한 칸 앞 원소의 인덱스

            while (j >= 0 && temp < arr[j]) { // 배열의 맨 앞까지 가거나 시작 원소보다 작은 값을 만날 때까지

                arr[j + 1] = arr[j]; // 자리 바꾸기(뒤로 밀기)

                j--;
            }

            arr[j + 1] = temp; // 반복이 끝난 경우 j 번째 원소가 더 작다는 의미이므로 그 앞에 위치해야 한다.
        }
    }
}