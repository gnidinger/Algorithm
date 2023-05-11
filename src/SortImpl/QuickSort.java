package SortImpl;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {4, 16, 31, 5, 4, 17, 1, 10, 15, 3, 16, 6, 7, 2, 2, 1, 5, 13, 17, 14, 4, 0};

        quickSortImpl(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSortImpl(int[] arr, int lo, int hi) {

        if (lo >= hi) return; // 대상 배열의 크기가 1 이하일 경우 탈출

        int pivot = partitionStep(arr, lo, hi); // Partition Step 진행

        quickSortImpl(arr, lo, pivot - 1); // 정렬이 끝난 pivot 기준으로 배열 쪼개서 재귀호출(왼쪽)
        quickSortImpl(arr, pivot + 1, hi); // 오른쪽
    }

    public static int partitionStep(int[] arr, int lo, int hi) {

        int left = lo; // 주어진 배열의 lo, hi, pivot 설정
        int right = hi;
        int pivot = arr[lo];

        while (left < right) {

            while (arr[right] >= pivot && left < right) { // pivot 보다 작은 값을 만날 때까지 right--;
                right--;
            }

            while (arr[left] <= pivot && left < right) { // pivot 보다 큰 값을 만날 때까지 left++
                left++;
            }

            swap(arr, left, right); // 값을 찾으면 스왑. 못 찾으면 left = right 인 곳에서 자체 스왑
        }

        swap(arr, lo, left); // left = right 인 원소와 pivot 교환

        return left; // pivot 이 옯겨간, 즉 정렬된 곳의 인덱스 반환
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
