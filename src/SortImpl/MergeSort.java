package SortImpl;

import java.util.Arrays;

public class MergeSort {

    private static int[] temp; // 임시 배열 전역변수로 선언

    public static void main(String[] args) {

        int[] arr = {4, 31, 5, 4, 17, 1, 10, 15, 3};

        temp = new int[arr.length];
        mergeSortImpl(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSortImpl(int[] arr, int start, int end) {

        if (start == end) return; // 끝까지 쪼개면 리턴

        int mid = (start + end) / 2; // 절반으로 나누기

        mergeSortImpl(arr, start, mid); // 왼쪽 절반 재귀호출
        mergeSortImpl(arr, mid + 1, end); // 오른쪽 절반 재귀호출

//        -----------------------------------------------------------
//        쪼개기 끝났으니 합치기
//        -----------------------------------------------------------

        int left = start; // 왼쪽 부분 배열 시작점
        int right = mid + 1; // 오른쪽 부분 배열 시작점
        int idx = left; // 비교 후 채워넣을 배열의 인덱스

        while (left <= mid && right <= end) {
            /*
             * 왼쪽 부분 배열의 left 번째 요소가 오른쪽 부분 배열의 right 번째 요소보다 작거나 같을 경우
             * idx 자리에 left 번째 요소를 넣고 left++ && idx++
             */
            if (arr[left] <= arr[right]) {
                temp[idx] = arr[left];
                idx++;
                left++;
            }
            /*
             * 반대의 경우
             */
            else {
                temp[idx] = arr[right];
                idx++;
                right++;
            }
        }
        /*
         * 왼쪽 부분 배열이 먼저 전부 비워졌을 경우(left > mid)
         * 오른쪽 부분 배열은 아직 남아있으므로
         * 순서대로 나머지 원소를 채워넣는다
         */
        if (left > mid) {
            while (right <= end) {
                temp[idx] = arr[right];
                idx++;
                right++;
            }
        }
        /*
         * 반대의 경우
         */
        else {
            while (left <= mid) {
                temp[idx] = arr[left];
                idx++;
                left++;
            }
        }
        /*
         * 기존 배열에 넣어주기
         */
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }
}
