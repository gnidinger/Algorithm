package SortImpl;

import java.util.Arrays;

public class CountingSort {

    private static int[] result;

    public static void main(String[] args) {

        int[] target = {4, 16, 31, 5, 4, 17, 1, 10, 15, 3, 16, 6, 7, 2, 2, 1, 5, 13, 17, 14, 4, 0};

        countingSortImpl(target);

        System.out.println(Arrays.toString(result));
    }

    public static void countingSortImpl(int[] target) {

        int[] counting = new int[Arrays.stream(target).max().getAsInt() + 1];
        result = new int[target.length];

        for (int i = 0; i < target.length; i++) { // Counting
            counting[target[i]]++;
        }

        for (int i = 1; i < counting.length; i++) { // 누적 합
            counting[i] += counting[i - 1];
        }

        for (int i = target.length - 1; i >= 0; i--) { // 정렬
            counting[target[i]]--; // 해당 인덱스 값을 하나 줄여주고
            result[counting[target[i]]] = target[i]; // 줄여진 수를 인덱스 삼아 result에 값 채우기
        }
    }
}
